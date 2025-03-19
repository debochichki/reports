package com.demo.reports;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.demo.reports.model.PlayerTotals;
import com.demo.reports.service.CurrencyRatesService;
import com.demo.reports.service.ReportsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} providing operations for fetching data for reports
 *
 * @author dimitar.debochichki
 */
@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {
    
    private final CurrencyRatesService currencyRatesService;
    private final ReportsService reportsService;
    
    @GetMapping("/currency-rates")
    public Map<String, BigDecimal> getCurrencyRates() {
        return currencyRatesService.getToDollarBucksRates();
    }
    
    @GetMapping("/player-totals")
    public List<PlayerTotals> getPlayerTotals() {
        return reportsService.getPlayerTotalsInDollarBucks();
    }
}
