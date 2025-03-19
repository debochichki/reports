package com.demo.reports.service;

import static com.demo.reports.util.Currency.DLB;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.SequencedCollection;

import com.demo.reports.model.PlayerTotals;
import com.demo.reports.repository.ReportsRepository;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportsService {

    private final ReportsRepository reportsRepository;
    private final CurrencyRatesService currencyRatesService;
    
    /**
     * Get player totals converted to DollarBucks
     *
     * @return player totals list
     */
    public List<PlayerTotals> getPlayerTotalsInDollarBucks() {
        return reportsRepository.getPlayerTotalsPerCurrency().stream()
            .map(this::convertPlayerTotalsToDollarBucks)
            .collect(groupingBy(playerTotals -> new PlayerTotalsGroupingFields(playerTotals.getPlayer(), playerTotals.getCurrency()),
                collectingAndThen(toList(), ReportsService::aggregatePlayerTotals)))
            .values()
            .stream()
            .toList();
    }
    
    private PlayerTotals convertPlayerTotalsToDollarBucks(final PlayerTotals playerTotals) {
        final var totalBetDlb = currencyRatesService.convertToDollarBucks(playerTotals.getCurrency(), playerTotals.getTotalBet());
        final var totalWinDlb = currencyRatesService.convertToDollarBucks(playerTotals.getCurrency(), playerTotals.getTotalWin());
        return new PlayerTotals(playerTotals.getPlayer(), totalBetDlb, totalWinDlb, DLB.getCode());
    }
    
    private static PlayerTotals aggregatePlayerTotals(final SequencedCollection<PlayerTotals> list) {
        final var playerDetails = list.getFirst();
        return list.stream()
            .reduce(new PlayerTotals(playerDetails.getPlayer(), BigDecimal.ZERO, BigDecimal.ZERO, playerDetails.getCurrency()),
                ReportsService::combineTotals);
    }
    
    private static PlayerTotals combineTotals(final PlayerTotals a,
                                              final PlayerTotals b) {
        return a.withTotalBet(a.getTotalBet().add(b.getTotalBet()))
            .withTotalWin(a.getTotalWin().add(b.getTotalWin()));
    }
    
    private record PlayerTotalsGroupingFields(String player, String currency){}
}
