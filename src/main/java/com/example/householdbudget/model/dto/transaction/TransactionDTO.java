package com.example.householdbudget.model.dto.transaction;

import java.time.format.DateTimeFormatter;

import com.example.householdbudget.model.entity.transaction.TransactionEntity;

public record TransactionDTO(
    /** 
     * ID
     */
    long id,
    /** 
     * 取引日付
     */
    String transactionDate,
    /**
     * 取引種別
     */
    String transactionType,
    /**
     * 金額
     */
    int amount,
    /**
     * カテゴリ
     */
    String category,
    /**
     * 支払い方法
     */
    String paymentMethod,
    /**
     * 説明
     */
    String description
) {
    public static TransactionDTO ToDTO(TransactionEntity entity) {
        return new TransactionDTO(
            entity.id(),
            entity.transactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            entity.transactionType().getName(),
            entity.amount(),
            entity.category().getName(),
            entity.paymentMethod().getName(),
            entity.description()
        );
    }
}
