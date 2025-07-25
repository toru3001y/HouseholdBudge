package com.example.householdbudget.model.dto.transaction;

import java.util.Arrays;
import java.util.List;

/**
 * カテゴリを表すEnum
 */
public enum CategoryType {
    
    // 収入カテゴリ
    SALARY("給与", TransactionType.INCOME),
    SIDE_JOB("副業", TransactionType.INCOME),
    INVESTMENT("投資", TransactionType.INCOME),
    OTHER_INCOME("その他収入", TransactionType.INCOME),
    
    // 支出カテゴリ
    FOOD("食費", TransactionType.EXPENSE),
    TRANSPORTATION("交通費", TransactionType.EXPENSE),
    UTILITIES("光熱費", TransactionType.EXPENSE),
    ENTERTAINMENT("娯楽費", TransactionType.EXPENSE),
    MEDICAL("医療費", TransactionType.EXPENSE),
    OTHER_EXPENSE("その他支出", TransactionType.EXPENSE);
    
    private final String name;
    private final TransactionType transactionType;
    
    /**
     * コンストラクタ
     * @param name カテゴリ名
     * @param transactionType 対応する取引種別
     */
    CategoryType(String name, TransactionType transactionType) {
        this.name = name;
        this.transactionType = transactionType;
    }
    
    /**
     * カテゴリ名を取得
     * @return 日本語のカテゴリ名
     */
    public String getName() {
        return name;
    }
    
    /**
     * 対応する取引種別を取得
     * @return TransactionType
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }
    
    /**
     * カテゴリ名から対応するEnumを取得
     * @param name カテゴリ名
     * @return 対応するCategoryType
     * @throws IllegalArgumentException 無効なカテゴリ名の場合
     */
    public static CategoryType fromName(String name) {
        for (CategoryType category : values()) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException("無効なカテゴリ: " + name);
    }
    
    /**
     * 指定した取引種別に対応するカテゴリ一覧を取得
     * @param transactionType 取引種別
     * @return 対応するカテゴリのリスト
     */
    public static List<CategoryType> getByTransactionType(TransactionType transactionType) {
        return Arrays.stream(values())
                .filter(category -> category.getTransactionType() == transactionType)
                .toList();
    }
    
    /**
     * 収入カテゴリ一覧を取得
     * @return 収入カテゴリのリスト
     */
    public static List<CategoryType> getIncomeCategories() {
        return getByTransactionType(TransactionType.INCOME);
    }
    
    /**
     * 支出カテゴリ一覧を取得
     * @return 支出カテゴリのリスト
     */
    public static List<CategoryType> getExpenseCategories() {
        return getByTransactionType(TransactionType.EXPENSE);
    }
    
    /**
     * 収入カテゴリかどうか判定
     * @return 収入カテゴリの場合true
     */
    public boolean isIncome() {
        return transactionType == TransactionType.INCOME;
    }
    
    /**
     * 支出カテゴリかどうか判定
     * @return 支出カテゴリの場合true
     */
    public boolean isExpense() {
        return transactionType == TransactionType.EXPENSE;
    }
    
    /**
     * 文字列表現（カテゴリ名を返す）
     * @return 日本語のカテゴリ名
     */
    @Override
    public String toString() {
        return name;
    }
}