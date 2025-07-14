package com.example.householdbudget.model.dto;

import java.time.format.DateTimeFormatter;

import com.example.householdbudget.model.entity.TransactionEntity;

public record TransactionDto(
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
    public static TransactionDto ToDTO(TransactionEntity entity) {
        return new TransactionDto(
            entity.id(),
            entity.transactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            entity.transactionType(),
            entity.amount(),
            entity.category(),
            entity.paymentMethod(),
            entity.description()
        );
    }
}
