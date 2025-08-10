package com.example.householdbudget.model.dto.summary;

import com.example.householdbudget.model.entity.summary.ExpenseCategoryEntity;

public record ExpenseCategoryDTO(
    String category,
    double amount,
    double percentage
) {
    public static ExpenseCategoryDTO toExpenseCategoryDTO(ExpenseCategoryEntity entity) {
        return new ExpenseCategoryDTO(
            entity.category(),
            entity.amount(),
            entity.percentage()
        );
    }
}
