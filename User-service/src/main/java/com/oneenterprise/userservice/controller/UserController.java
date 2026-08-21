package com.oneenterprise.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneenterprise.userservice.dto.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public UserResponse getUser(
            @PathVariable Long id) {

        return new UserResponse(
                id,
                "Sachin",
                "sachin@example.com"
        );
    }
}