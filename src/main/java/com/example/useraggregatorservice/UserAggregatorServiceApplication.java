package com.example.useraggregatorservice;

import com.example.useraggregatorservice.config.DataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataSourceProperties.class)
@ConfigurationPropertiesScan("java")
public class UserAggregatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAggregatorServiceApplication.class, args);
    }

}
