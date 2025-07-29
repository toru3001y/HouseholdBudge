package com.example.householdbudget.model.entity.summary;

import java.math.BigDecimal;

public record YearlySummaryEntity(
    /** 年（例：2024） */
    Integer year,
    
    /** 年間収入合計 */
    BigDecimal totalIncome,
    
    /** 年間支出合計 */
    BigDecimal totalExpense,
    
    /** 年間収支（収入 - 支出） */
    BigDecimal balance,
    
    /** 平均貯蓄率（%） */
    BigDecimal averageSavingsRate
) {
    
}
