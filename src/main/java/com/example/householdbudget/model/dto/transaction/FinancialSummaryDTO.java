package com.example.householdbudget.model.dto.transaction;

import com.example.householdbudget.model.entity.transaction.TransactionSummaryEntity;

/**
 * 財務サマリー
 */
public record FinancialSummaryDTO(
    long totalIncome,
    long totalExpense
) {

    public static FinancialSummaryDTO ToDTO(TransactionSummaryEntity entity) {
        return new FinancialSummaryDTO(entity.totalIncome(), entity.totalExpense());
    }

    // 収支計算
    public long getBalance() {
        return totalIncome - totalExpense;
    }
}
