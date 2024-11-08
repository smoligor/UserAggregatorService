package com.example.useraggregatorservice.service.impl;

import com.example.useraggregatorservice.config.DataSourceProperties;
import com.example.useraggregatorservice.dto.UserDto;
import com.example.useraggregatorservice.entity.User;
import com.example.useraggregatorservice.repository.UserRepository;
import com.example.useraggregatorservice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    DataSourceProperties dataSourceProperties;

    @Override
    public List<UserDto> getAllUsers(String username) {
        List<UserDto> userDtos = new ArrayList<>();
        dataSourceProperties.getDataSource().entrySet().forEach(entry -> {
            List<User> users = repository.findAllUsers(entry.getKey(), entry.getValue().getMapping(), username);
            users.forEach(user -> {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);
                userDtos.add(userDto);
            });
        });

        return userDtos;
    }

    public UserServiceImpl(UserRepository repository, DataSourceProperties dataSourceProperties) {
        this.repository = repository;
        this.dataSourceProperties = dataSourceProperties;
    }
}
