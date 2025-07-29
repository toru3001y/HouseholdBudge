package com.example.householdbudget.repository.summary;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.householdbudget.model.entity.summary.ExpenseCategoryEntity;
import com.example.householdbudget.model.entity.summary.IncomeCategoryEntity;
import com.example.householdbudget.model.entity.summary.MonthlySummaryEntity;
import com.example.householdbudget.model.entity.summary.YearlySummaryEntity;

@Mapper
public interface SummaryRepository {
    // 月別収支集計を取得するメソッドを定義
    List<MonthlySummaryEntity> selectMonthlySummary();
    // 最新月の収入カテゴリ別集計を取得するメソッドを定義
    List<IncomeCategoryEntity> selectLatestMonthIncomeCategories(@Param("year") int year, @Param("month") int month);
    // 最新月の支出カテゴリ別集計を取得するメソッドを定義
    List<ExpenseCategoryEntity> selectLatestMonthExpenseCategories(@Param("year") int year, @Param("month") int month);
    // 前年の年間収支集計を取得するメソッドを定義
    Optional<YearlySummaryEntity> selectPreviousYearSummary();
}
