package com.example.householdbudget.model.entity.summary;

import java.math.BigDecimal;

public record MonthlySummaryEntity(
    /**
     * 年
     */
    int year,
    /**
     * 月
     */
    int month,
    /**
     * 月別総収入
     */
    BigDecimal totalIncome,
    /**
     * 月別総支出
     */
    BigDecimal totalExpense,
    /**
     * 収支差額
     */
    BigDecimal balance,
    /**
     * 前月比(%)
     */
    BigDecimal previousMonthComparisonRate,
    /**
     * 収入の前月比(%)
     */
    BigDecimal incomeComparisonRate,
    /**
     * 支出の前月比(%)
     */
    BigDecimal expenseComparisonRate,
    /**
     * 収支状況
     */
    String balanceStatus
) {

}
