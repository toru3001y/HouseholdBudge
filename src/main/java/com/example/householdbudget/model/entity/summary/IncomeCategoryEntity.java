package com.example.householdbudget.model.entity.summary;

public record IncomeCategoryEntity(
    String category,
    double amount,
    double percentage
) {
    
}
