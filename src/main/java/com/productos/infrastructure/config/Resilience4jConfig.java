package com.productos.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jConfig {

    @Bean
    public CircuitBreakerConfig customCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
               .failureRateThreshold(50)
               .waitDurationInOpenState(Duration.ofSeconds(60))
               .ringBufferSizeInHalfOpenState(10)
               .ringBufferSizeInClosedState(10)
               .build();
    }

    @Bean
    public RetryConfig customRetryConfig() {
        return RetryConfig.custom()
               .maxAttempts(3)
               .waitDuration(Duration.ofSeconds(1))
               .build();
    }

    @Bean
    public TimeLimiterConfig customTimeLimiterConfig() {
        return TimeLimiterConfig.custom()
               .timeoutDuration(Duration.ofSeconds(5))
               .build();
    }
}