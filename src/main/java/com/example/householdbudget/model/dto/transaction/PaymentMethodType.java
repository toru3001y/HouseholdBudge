package com.example.householdbudget.model.dto.transaction;

/**
 * 支払い方法を表すEnum
 */
public enum PaymentMethodType {
    
    CASH("現金"),
    CREDIT_CARD("クレジットカード"),
    ELECTRONIC_MONEY("電子マネー");
    
    private final String name;
    
    /**
     * コンストラクタ
     * @param name 支払い方法名
     */
    PaymentMethodType(String name) {
        this.name = name;
    }
    
    /**
     * 支払い方法名を取得
     * @return 日本語の支払い方法名
     */
    public String getName() {
        return name;
    }
    
    /**
     * 支払い方法名から対応するEnumを取得
     * @param name 支払い方法名
     * @return 対応するPaymentMethodType
     * @throws IllegalArgumentException 無効な支払い方法名の場合
     */
    public static PaymentMethodType fromName(String name) {
        for (PaymentMethodType method : values()) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        throw new IllegalArgumentException("無効な支払い方法: " + name);
    }
    
    /**
     * 現金かどうか判定
     * @return 現金の場合true
     */
    public boolean isCash() {
        return this == CASH;
    }
    
    /**
     * クレジットカードかどうか判定
     * @return クレジットカードの場合true
     */
    public boolean isCreditCard() {
        return this == CREDIT_CARD;
    }
    
    /**
     * 電子マネーかどうか判定
     * @return 電子マネーの場合true
     */
    public boolean isElectronicMoney() {
        return this == ELECTRONIC_MONEY;
    }
    
    /**
     * キャッシュレス決済かどうか判定
     * @return キャッシュレス決済の場合true
     */
    public boolean isCashless() {
        return this == CREDIT_CARD || this == ELECTRONIC_MONEY;
    }
    
    /**
     * 文字列表現（支払い方法名を返す）
     * @return 日本語の支払い方法名
     */
    @Override
    public String toString() {
        return name;
    }
}