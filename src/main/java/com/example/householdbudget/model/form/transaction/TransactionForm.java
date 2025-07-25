package com.example.householdbudget.model.form.transaction;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.householdbudget.model.dto.transaction.CategoryType;
import com.example.householdbudget.model.dto.transaction.PaymentMethodType;
import com.example.householdbudget.model.dto.transaction.TransactionType;
import com.example.householdbudget.model.entity.transaction.TransactionEntity;
import com.example.householdbudget.validation.RequiredLocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TransactionForm(
    /** 
     * 取引日付
     */
    @RequiredLocalDate(message = "取引日付は必須です")
    @PastOrPresent(message = "未来日付は入力できません。")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate transactionDate,
    /**
     * 取引種別
     */
    @NotBlank
    @Pattern(regexp = "INCOME|EXPENSE", message = "収入、支出のいずれかを入力してください。")
    String transactionType,
    /**
     * 金額
     */
    @NotNull
    @Min(value = 1, message = "1円以上の金額を入力してください。。")
    @Max(value = 9999999, message = "1,000万円未満の金額を入力してください。")
    Integer amount,
    /**
     * カテゴリ
     */
    @NotBlank
    @Pattern(regexp = "SALARY|SIDE_JOB|INVESTMENT|OTHER_INCOME|FOOD|TRANSPORTATION|UTILITIES|ENTERTAINMENT|MEDICAL|OTHER_EXPENSE", message = "給与、副業、投資、その他収入、食費、交通費、光熱費、娯楽費、医療費、その他支出のいずれかを入力してください。")
    String category,
    /**
     * 支払い方法
     */
    @NotBlank
    @Pattern(regexp = "CASH|CREDIT_CARD|ELECTRONIC_MONEY", message = "現金、クレジットカード、電子マネーのいずれかを入力してください。")
    String paymentMethod,
    /**
     * 説明
     */
    @Size(max = 200, message = "200文字以内で入力してください。")
    String description
) {
    public TransactionEntity toEntity() {
        return new TransactionEntity(
            null,
            transactionDate(),
            TransactionType.valueOf(transactionType()),
            amount(),
            CategoryType.valueOf(category()),
            PaymentMethodType.valueOf(paymentMethod()),
            description()
        );
    }


     public TransactionEntity toEntity(long id) {
        return new TransactionEntity(
            id,
            transactionDate(),
            TransactionType.valueOf(transactionType()),
            amount(),
            CategoryType.valueOf(category()),
            PaymentMethodType.valueOf(paymentMethod()),
            description()
        );
    }

    public static TransactionForm fromEntity(TransactionEntity entity) {
        return new TransactionForm(
            entity.transactionDate(),
            entity.transactionType().name(),
            entity.amount(),
            entity.category().name(),
            entity.paymentMethod().name(),
            entity.description()
        );
    }
}
