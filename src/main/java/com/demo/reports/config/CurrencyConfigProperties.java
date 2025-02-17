package com.demo.reports.config;


import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@Data
@ConfigurationProperties(prefix = "currency-rates")
public class CurrencyConfigProperties {
    
    private String provider;
    private String url;
    
}

