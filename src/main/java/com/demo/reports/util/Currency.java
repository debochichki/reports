package com.demo.reports.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Currency {
    
    DLB("DollarBuck"),
    EUC("EuroCoin"),
    MAR("Marka"),
    SOL("Solara");
    
    private final String displayName;
    
    public String getCode() {
        return name();
    }
}
