package com.example.useraggregatorservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mapping {
    private String id;
    private String username;
    private String name;
    private String surname;
}
