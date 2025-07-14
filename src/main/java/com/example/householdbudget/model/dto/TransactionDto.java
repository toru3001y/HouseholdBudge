package com.example.householdbudget.model.dto;

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
    
}
