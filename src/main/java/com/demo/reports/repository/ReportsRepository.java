package com.demo.reports.repository;

import java.util.List;

import com.demo.reports.model.PlayerTotals;

public interface ReportsRepository {
    
    List<PlayerTotals> getPlayerTotalsPerCurrency();
    
}
