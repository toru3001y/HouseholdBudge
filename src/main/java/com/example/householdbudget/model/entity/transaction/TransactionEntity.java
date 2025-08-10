package com.example.householdbudget.model.entity.transaction;

import java.time.LocalDate;

import com.example.householdbudget.model.dto.transaction.CategoryType;
import com.example.householdbudget.model.dto.transaction.PaymentMethodType;
import com.example.householdbudget.model.dto.transaction.TransactionType;

public record TransactionEntity(
    Long id,
    LocalDate transactionDate,
    TransactionType transactionType,
    int amount,
    CategoryType category,
    PaymentMethodType paymentMethod,
    String description
){
    
}
