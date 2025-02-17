package com.demo.reports.repository.impl;

import static com.demo.jooq.generated.tables.GameRounds.GAME_ROUNDS;
import static org.jooq.impl.DSL.sum;

import lombok.RequiredArgsConstructor;

import java.util.List;

import com.demo.reports.model.PlayerTotals;
import com.demo.reports.repository.ReportsRepository;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReportsRepositoryImpl implements ReportsRepository {
    
    private final DSLContext context;
    
    @Override
    public List<PlayerTotals> getPlayerTotalsPerCurrency() {
        return context.select(GAME_ROUNDS.PLAYER,
                sum(GAME_ROUNDS.BET_AMOUNT),
                sum(GAME_ROUNDS.WIN_AMOUNT),
                GAME_ROUNDS.CURRENCY)
            .from(GAME_ROUNDS)
            .groupBy(GAME_ROUNDS.PLAYER, GAME_ROUNDS.CURRENCY)
            .fetchInto(PlayerTotals.class);
    }
}
