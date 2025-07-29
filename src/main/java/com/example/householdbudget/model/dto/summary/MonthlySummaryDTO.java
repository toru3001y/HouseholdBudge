package com.example.householdbudget.model.dto.summary;

import java.math.BigDecimal;

import com.example.householdbudget.model.entity.summary.MonthlySummaryEntity;

public record MonthlySummaryDTO(
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

    /**
     * MonthlySummaryEntityをMonthlySummaryDTOに変換するメソッド
     * @param entity 月別収支集計のエンティティ
     * @return 月別収支集計のDTO
     */
    public static MonthlySummaryDTO toMonthlySummaryDTO(MonthlySummaryEntity entity) {
        return new MonthlySummaryDTO(
            entity.year(),
            entity.month(),
            entity.totalIncome(),
            entity.totalExpense(),
            entity.balance(),
            entity.previousMonthComparisonRate(),
            entity.incomeComparisonRate(),
            entity.expenseComparisonRate(),
            entity.balanceStatus()
        );
    }
}
