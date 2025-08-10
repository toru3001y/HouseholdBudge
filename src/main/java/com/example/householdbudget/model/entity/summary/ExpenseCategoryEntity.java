package com.example.householdbudget.model.entity.summary;

public record ExpenseCategoryEntity(
    String category,
    double amount,
    double percentage
) {
    
}
