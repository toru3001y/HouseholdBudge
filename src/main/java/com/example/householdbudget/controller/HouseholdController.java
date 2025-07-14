package com.example.householdbudget.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.householdbudget.model.dto.TransactionDto;

@Controller
@RequestMapping("/household")
public class HouseholdController {

    @GetMapping("/list")
    public String list(Model model) {
        var list = new ArrayList<TransactionDto>();
        list.add(new TransactionDto(1, "2025-01-15", "支出", 3500, "食費", "クレジットカード", "スーパーでの買い物"));
        list.add(new TransactionDto(2, "2025-01-14", "支出", 1500, "交通費", "電子マネー", "電車代"));
        model.addAttribute("transactions", list);
        return "household/list";
    }
}
