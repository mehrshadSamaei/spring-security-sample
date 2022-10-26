package com.example.testspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class TestSpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringSecurityApplication.class, args);
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_THREADLOCAL);
    }

}
