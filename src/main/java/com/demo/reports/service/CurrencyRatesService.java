package com.demo.reports.service;

import static com.demo.reports.util.Currency.EUC;
import static com.demo.reports.util.Currency.MAR;
import static com.demo.reports.util.Currency.SOL;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import jakarta.annotation.PostConstruct;

import com.demo.reports.config.CurrencyConfigProperties;
import com.demo.reports.util.CurrencyRatesProvider;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
@RequiredArgsConstructor
public class CurrencyRatesService {
    
    private final CurrencyConfigProperties currencyConfigProperties;
    private Map<String, BigDecimal> toDollarBuckRates;
    
    @PostConstruct
    private void postConstruct() {
        toDollarBuckRates = switch (CurrencyRatesProvider.valueOf(currencyConfigProperties.getProvider())) {
            case COINS -> getCoinsRates();
            case EXCHANGE -> getExchangeRates();
        };
    }
    
    public Map<String, BigDecimal> getCurrencyRates() {
        return Collections.unmodifiableMap(toDollarBuckRates);
    }
    
    public BigDecimal convertToDollarBucks(final String fromCurrency, final BigDecimal amount) {
        return toDollarBuckRates.get(fromCurrency).multiply(amount);
    }
    
    private static Map<String, BigDecimal> getCoinsRates() {
        return Map.of(EUC.getCode(), BigDecimal.valueOf(0.85),
            MAR.getCode(), BigDecimal.valueOf(1.05),
            SOL.getCode(), BigDecimal.valueOf(2L));
    }
    
    private static Map<String, BigDecimal> getExchangeRates() {
        return Map.of(EUC.getCode(), BigDecimal.valueOf(0.8),
            MAR.getCode(), BigDecimal.valueOf(1.12),
            SOL.getCode(), BigDecimal.valueOf(1.95));
    }
}


