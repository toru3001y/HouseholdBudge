# 家計簿アプリケーション (Household Budget)

Spring Boot と MyBatis を使用したシンプルな家計簿管理アプリケーション

## 概要

日々の収入と支出を記録・管理できる Web アプリケーションです。直感的な UI で、収支の登録、一覧表示、月別・年別の集計分析ができます。

## 主な機能

- **収支登録** - 収入・支出の記録と編集
- **収支一覧** - 取引履歴の表示と管理
- **月別集計** - カテゴリ別収支の月次分析
- **年間サマリー** - 年単位での収支概要
- **支払方法分析** - 決済手段別の利用状況

## 技術スタック

- **Backend:** Spring Boot 3.4.7, Java 21
- **Database:** PostgreSQL
- **ORM:** MyBatis 3.0.4
- **Frontend:** Thymeleaf, Bootstrap 5.2.3
- **Build Tool:** Gradle

## 前提条件

- Java 21
- PostgreSQL 12+
- Gradle 8.0+

## セットアップ

### 1. データベースの設定

PostgreSQL に以下のデータベースとユーザーを作成:

```sql
CREATE DATABASE household_budget;
CREATE USER springuser WITH PASSWORD 'p@ss';
GRANT ALL PRIVILEGES ON DATABASE household_budget TO springuser;
```

### 2. アプリケーションの起動

```bash
# リポジトリのクローン
git clone [repository-url]
cd household-budget

# アプリケーションの実行
./gradlew bootRun
```

### 3. アクセス

ブラウザで http://localhost:8080 にアクセス

## プロジェクト構造

```
src/main/java/com/example/householdbudget/
├── config/              # 設定クラス (TypeHandler等)
├── controller/          # Web コントローラ
│   ├── summary/        # 集計機能
│   └── transaction/    # 取引機能
├── model/
│   ├── dto/            # データ転送オブジェクト
│   ├── entity/         # エンティティクラス
│   └── form/           # フォームオブジェクト
├── repository/         # データアクセス層
├── service/           # ビジネスロジック
└── validation/        # カスタムバリデータ

src/main/resources/
├── templates/         # Thymeleaf テンプレート
├── static/           # 静的リソース
├── schema.sql        # DDL
├── data.sql          # 初期データ
└── application.properties
```

## データベーススキーマ

主要テーブル:
- `transactions` - 取引データ
- `monthly_summaries` - 月次集計
- `yearly_summaries` - 年次集計
- `income_categories` - 収入カテゴリ別集計
- `expense_categories` - 支出カテゴリ別集計

## API エンドポイント

| Path | Method | 説明 |
|------|--------|------|
| `/` | GET | ホーム画面 |
| `/transaction/register` | GET/POST | 収支登録 |
| `/transaction/list` | GET | 収支一覧 |
| `/summary/monthly` | GET | 月別集計 |

## 開発

### テスト実行
```bash
./gradlew test
```

### ビルド
```bash
./gradlew build
```

## ライセンス

このプロジェクトは MIT ライセンスの下で公開されています。