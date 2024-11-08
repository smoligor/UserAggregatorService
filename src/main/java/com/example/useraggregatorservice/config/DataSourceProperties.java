package com.example.useraggregatorservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "spring")
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceProperties {

    private Map<String, DataSourceProperty> dataSource = new HashMap<>();

}
