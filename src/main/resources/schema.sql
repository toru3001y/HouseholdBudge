-- 1. 既存テーブル削除
DROP TABLE IF EXISTS household_transactions;

-- 2. household_transactionsテーブル作成
CREATE TABLE household_transactions (
    id BIGSERIAL PRIMARY KEY,
    transaction_date DATE NOT NULL,
    transaction_type VARCHAR(10) NOT NULL CHECK (transaction_type IN ('収入', '支出')),
    amount DECIMAL(10,2) NOT NULL CHECK (amount > 0),
    category VARCHAR(50) NOT NULL,
    payment_method VARCHAR(20) NOT NULL CHECK (payment_method IN ('現金', 'クレジットカード', '電子マネー')),
    description VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. テーブルとカラムにコメント追加
COMMENT ON TABLE household_transactions IS '収支取引テーブル - 家計簿の収入・支出データを管理';

COMMENT ON COLUMN household_transactions.id IS 'プライマリキー - 取引ID（自動採番）';
COMMENT ON COLUMN household_transactions.transaction_date IS '取引日付 - 収入・支出が発生した日付';
COMMENT ON COLUMN household_transactions.transaction_type IS '取引種別 - 収入または支出';
COMMENT ON COLUMN household_transactions.amount IS '金額 - 取引金額（正の数値のみ、小数点以下2桁まで）';
COMMENT ON COLUMN household_transactions.category IS 'カテゴリ - 収入・支出の分類（食費、交通費、給与など）';
COMMENT ON COLUMN household_transactions.payment_method IS '支払い方法 - 現金、クレジットカード、電子マネーのいずれか';
COMMENT ON COLUMN household_transactions.description IS '備考 - 取引の詳細説明（任意入力、最大200文字）';
COMMENT ON COLUMN household_transactions.created_at IS '作成日時 - レコード作成時のタイムスタンプ';
COMMENT ON COLUMN household_transactions.updated_at IS '更新日時 - レコード最終更新時のタイムスタンプ';
