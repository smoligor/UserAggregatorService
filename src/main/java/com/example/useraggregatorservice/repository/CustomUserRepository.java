package com.example.useraggregatorservice.repository;

import com.example.useraggregatorservice.config.Mapping;
import com.example.useraggregatorservice.entity.User;

import java.util.List;

public interface CustomUserRepository {
    List<User> findAllUsers(String db, Mapping mapping, String userNameFilter);
}
