package com.demo.reports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

import java.math.BigDecimal;

@Data
@With
@AllArgsConstructor
public class PlayerTotals {
    
    private String player;
    private BigDecimal totalBet;
    private BigDecimal totalWin;
    private String currency;
    
}
