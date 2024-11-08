package com.example.useraggregatorservice.controller;

import com.example.useraggregatorservice.dto.UserDto;
import com.example.useraggregatorservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "API for aggregating users data from multiple db.")
public class UserAggregatorController {

    private final UserService userService;


    public UserAggregatorController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Retrieve all users", description = "Aggregates users from all configured databases.")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(required = false) String userNameFilter) {
        List<UserDto> userDtos = userService.getAllUsers(userNameFilter);
        return ResponseEntity.ok(userDtos);
    }
}
