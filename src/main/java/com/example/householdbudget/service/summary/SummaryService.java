package com.example.householdbudget.service.summary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.householdbudget.model.entity.summary.ExpenseCategoryEntity;
import com.example.householdbudget.model.entity.summary.IncomeCategoryEntity;
import com.example.householdbudget.model.entity.summary.MonthlySummaryEntity;
import com.example.householdbudget.repository.summary.SummaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SummaryService {
 
    private final SummaryRepository summaryRepository;

    public List<MonthlySummaryEntity> getMonthlySummary() {
        return summaryRepository.selectMonthlySummary();
    }

    public List<IncomeCategoryEntity> getLatestMonthIncomeCategories(int year, int month) {
        return summaryRepository.selectLatestMonthIncomeCategories(year, month);
    }

    public List<ExpenseCategoryEntity> getLatestMonthExpenseCategories(int year, int month) {
        return summaryRepository.selectLatestMonthExpenseCategories(year, month);
    }
}
