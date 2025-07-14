package com.example.householdbudget.model.entity;

import java.time.LocalDate;

public record TransactionEntity(
    Long id,
    LocalDate transactionDate,
    String transactionType,
    int amount,
    String category,
    String paymentMethod,
    String description
){
    
}
