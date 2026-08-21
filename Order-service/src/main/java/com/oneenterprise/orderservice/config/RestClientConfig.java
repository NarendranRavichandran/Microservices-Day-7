package com.oneenterprise.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient paymentServiceRestClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8083")
                .build();
    }
}