package com.monitoring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
class WebClientConfig {
    private final EndpointConfig endpointConfig;
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(endpointConfig.getUrl()).build();
    }

}