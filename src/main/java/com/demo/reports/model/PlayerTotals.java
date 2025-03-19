package com.demo.reports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

import java.math.BigDecimal;

/**
 * DTO for player total played amounts, converted to a given currency
 *
 * @author dimitar.debochichki
 */
@Data
@With
@AllArgsConstructor
public class PlayerTotals {
    
    private String player;
    private BigDecimal totalBet;
    private BigDecimal totalWin;
    private String currency;
    
}
