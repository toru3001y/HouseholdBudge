package com.example.householdbudget.model.dto.summary;

import com.example.householdbudget.model.entity.summary.IncomeCategoryEntity;

public record IncomeCategoryDTO(
    String category,
    double amount,
    double percentage
) {
    public static IncomeCategoryDTO toIncomeCategoryDTO(IncomeCategoryEntity entity) {
        return new IncomeCategoryDTO(
            entity.category(),
            entity.amount(),
            entity.percentage()
        );
    }
}
