package com.example.useraggregatorservice.repository.impl;

import com.example.useraggregatorservice.config.Mapping;
import com.example.useraggregatorservice.entity.User;
import com.example.useraggregatorservice.repository.CustomUserRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JdbcTemplate jdbcTemplate1;
    private final JdbcTemplate jdbcTemplate2;

    @Autowired
    public CustomUserRepositoryImpl(@Autowired @Qualifier("db1DataSourceProperties") DataSourceProperties dataSource1,
                                    @Autowired @Qualifier("db2DataSourceProperties") DataSourceProperties dataSource2) {
        this.jdbcTemplate1 = new JdbcTemplate(dataSource1.initializeDataSourceBuilder()
            .driverClassName(dataSource1.getDriverClassName())
            .url(dataSource1.getUrl())
            .password(dataSource1.getPassword())
            .type(HikariDataSource.class)
            .username(dataSource1.getUsername())
            .build());
        this.jdbcTemplate2 = new JdbcTemplate(dataSource2.initializeDataSourceBuilder()
            .driverClassName(dataSource2.getDriverClassName())
            .url(dataSource2.getUrl())
            .password(dataSource2.getPassword())
            .type(HikariDataSource.class)
            .username(dataSource2.getUsername())
            .build());
    }

    @Override
    public List<User> findAllUsers(String db, Mapping mapping, String usernameFilter) {
        JdbcTemplate jdbcTemplate;
        if ("db1".equals(db)) {
            jdbcTemplate = jdbcTemplate1;
        } else if ("db2".equals(db)) {
            jdbcTemplate = jdbcTemplate2;
        } else {
            throw new IllegalArgumentException("Invalid database: " + db);
        }


        StringBuilder queryBuilder = new StringBuilder(String.format(
            "SELECT %s AS id, %s AS username, %s AS name, %s AS surname FROM users",
            mapping.getId(),
            mapping.getUsername(),
            mapping.getName(),
            mapping.getSurname()
        ));

        addFilter(mapping, usernameFilter, queryBuilder);


        return jdbcTemplate.query(queryBuilder.toString(), new UserRowMapper());
    }

    private void addFilter(Mapping mapping, String usernameFilter, StringBuilder queryBuilder) {
        if (usernameFilter != null && !usernameFilter.isEmpty()) {
            queryBuilder.append(" WHERE ").append(mapping.getUsername()).append("=")
                .append("'")
                .append(usernameFilter)
                .append("'");
        }
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("name"),
                rs.getString("surname")
            );
        }
    }
}
