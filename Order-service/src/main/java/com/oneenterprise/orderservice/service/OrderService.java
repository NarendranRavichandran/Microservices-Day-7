package com.oneenterprise.orderservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.oneenterprise.orderservice.client.PaymentClient;
import com.oneenterprise.orderservice.client.UserClient;
import com.oneenterprise.orderservice.dto.OrderResponse;
import com.oneenterprise.orderservice.dto.PaymentResponse;
import com.oneenterprise.orderservice.dto.UserResponse;
import com.oneenterprise.orderservice.exception.OrderNotFoundException;

@Service
public class OrderService {

    private final UserClient userClient;

    private final PaymentClient paymentClient;

    private final Map<Long, Long> orders =
            new HashMap<>();

    public OrderService(
            UserClient userClient,
            PaymentClient paymentClient) {

        this.userClient =
                userClient;

        this.paymentClient =
                paymentClient;

      
        orders.put(1001L, 1L);
        orders.put(1002L, 2L);
        orders.put(1003L, 3L);
    }

    public OrderResponse getOrderById(
            Long orderId) {

        Long userId =
                orders.get(orderId);

        if (userId == null) {

            throw new OrderNotFoundException(
                    orderId
            );
        }

     
        UserResponse user =
                userClient.getUserById(
                        userId
                );

      
        PaymentResponse payment =
                paymentClient.processPayment(
                        orderId
                );

        return new OrderResponse(
                orderId,
                userId,
                "CONFIRMED",
                user,
                payment
        );
    }

    public String getPaymentCircuitState() {

        return paymentClient
                .getCircuitState();
    }
}