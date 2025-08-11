package com.example.householdbudget.controller.summary;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.householdbudget.model.dto.summary.ExpenseCategoryDTO;
import com.example.householdbudget.model.dto.summary.IncomeCategoryDTO;
import com.example.householdbudget.model.dto.summary.MonthlySummaryDTO;
import com.example.householdbudget.model.dto.summary.YearlySummaryDTO;
import com.example.householdbudget.service.summary.SummaryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/summary")
@RequiredArgsConstructor
public class SummaryController {
    
    private final SummaryService summaryService;

    @GetMapping("/monthly")
    public String summary(Model model) {
        // 月別収支集計を取得
        var monthlySummary = summaryService.getMonthlySummary().stream().map(MonthlySummaryDTO::toMonthlySummaryDTO).toList();
        // 当月サマリーを取得
        var latestMonth = monthlySummary.stream().findFirst().orElse(null);
        List<IncomeCategoryDTO> incomeCategories = List.of();
        List<ExpenseCategoryDTO> expenseCategories = List.of();
        if (latestMonth != null) {
            incomeCategories = summaryService.getLatestMonthIncomeCategories(latestMonth.year(), latestMonth.month())
                .stream()
                .map(IncomeCategoryDTO::toIncomeCategoryDTO)
                .toList();
            expenseCategories = summaryService.getLatestMonthExpenseCategories(latestMonth.year(), latestMonth.month())
                .stream()
                .map(ExpenseCategoryDTO::toExpenseCategoryDTO)
                .toList();
        }

        var yearlySummary = summaryService.getPreviousYearSummary()
                .map(YearlySummaryDTO::toYearlySummaryDTO).orElse(null);

        model.addAttribute("monthlySummary", monthlySummary);
        model.addAttribute("latestMonth", latestMonth);
        model.addAttribute("hasData", !monthlySummary.isEmpty());
        model.addAttribute("incomeCategories", incomeCategories);
        model.addAttribute("expenseCategories", expenseCategories);
        model.addAttribute("yearlySummary", yearlySummary);
        model.addAttribute("chartData", monthlySummary);

        return "summary/monthly";
    }
}
