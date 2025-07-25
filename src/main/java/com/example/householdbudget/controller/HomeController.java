package com.example.householdbudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.householdbudget.model.dto.transaction.FinancialSummaryDTO;
import com.example.householdbudget.service.transaction.TransactionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TransactionService service;

    @GetMapping("/")
    public String index(Model model) {
        var financialSummaryDTO = FinancialSummaryDTO.ToDTO(service.getFinancialSummary());
        model.addAttribute("summary", financialSummaryDTO);
        model.addAttribute("pageTitle", "ホーム");
        model.addAttribute("currentPage", "home");
        return "index";
    }
}
