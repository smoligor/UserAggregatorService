package com.example.useraggregatorservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceProperty {
    private String driverClassName;
    private String name;
    private String url;
    private String username;
    private String password;
    private Mapping mapping;
}