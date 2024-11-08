package com.example.useraggregatorservice.service;

import com.example.useraggregatorservice.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    List<UserDto> getAllUsers(String userName);
}
