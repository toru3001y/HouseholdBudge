package com.example.householdbudget.model.dto.transaction;

/**
 * 取引種別を表すEnum
 */
public enum TransactionType {
    
    INCOME("収入"),
    EXPENSE("支出");
    
    private final String name;
    
    /**
     * コンストラクタ
     * @param name 表示名
     */
    TransactionType(String name) {
        this.name = name;
    }
    
    /**
     * 表示名を取得
     * @return 日本語の表示名
     */
    public String getName() {
        return name;
    }
    
    /**
     * 表示名から対応するEnumを取得
     * @param name 表示名（"収入" または "支出"）
     * @return 対応するTransactionType
     * @throws IllegalArgumentException 無効な表示名の場合
     */
    public static TransactionType fromName(String name) {
        for (TransactionType type : values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("無効な取引種別: " + name);
    }
    
    /**
     * 文字列表現（表示名を返す）
     * @return 日本語の表示名
     */
    @Override
    public String toString() {
        return name;
    }
}