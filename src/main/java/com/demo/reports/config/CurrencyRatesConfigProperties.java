package com.demo.reports.config;


import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties bean for currency rates
 *
 * @author dimitar.debochichki
 */
@Data
@ConfigurationProperties(prefix = "currency-rates")
public class CurrencyRatesConfigProperties {
    
    private String provider;
    private String url;
    
}

