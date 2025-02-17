package com.demo.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.demo")
@SpringBootApplication
public class ReportsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ReportsApplication.class, args);
    }
    
}
