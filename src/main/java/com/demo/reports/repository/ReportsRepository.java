package com.demo.reports.repository;

import java.util.List;

import com.demo.reports.model.PlayerTotals;

import org.springframework.stereotype.Repository;

/**
 * {@link Repository} for reports queries
 *
 * @author dimitar.debochichki
 */
public interface ReportsRepository {
    
    /**
     * Retrieve player totals per currency
     *
     * @return {@link List<PlayerTotals>}
     */
    List<PlayerTotals> getPlayerTotalsPerCurrency();
    
}
