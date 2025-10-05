package com.thomazllr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {

    @Bean("forkifyApiClient")
    public RestClient forkifyApiClient(RestClient.Builder builder,
                                       ForkifyApiConfigurationProperties properties) {
        return builder
                .baseUrl(properties.getUrl())
                .build();
    }
}