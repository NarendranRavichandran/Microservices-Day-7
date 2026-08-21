package com.oneenterprise.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.oneenterprise.orderservice.dto.UserResponse;
import com.oneenterprise.orderservice.exception.UserServiceUnavailableException;

@Component
public class UserClient {

    private final RestClient restClient;

    public UserClient(
            RestClient userServiceRestClient) {

        this.restClient =
                userServiceRestClient;
    }

    public UserResponse getUserById(
            Long userId) {

        try {

            return restClient
                    .get()
                    .uri(
                            "/users/{id}",
                            userId
                    )
                    .retrieve()
                    .body(UserResponse.class);

        } catch (Exception exception) {

            throw new UserServiceUnavailableException(
                    "Unable to communicate with User Service",
                    exception
            );
        }
    }
}