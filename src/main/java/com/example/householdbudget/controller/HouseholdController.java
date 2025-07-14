package com.example.householdbudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.householdbudget.model.dto.TransactionDto;
import com.example.householdbudget.service.TransactionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/household")
@RequiredArgsConstructor
public class HouseholdController {

    private final TransactionService service;

    @GetMapping("/list")
    public String list(Model model) {
        var list = service.search().stream().map(TransactionDto::ToDTO).toList();
        model.addAttribute("transactions", list);
        return "household/list";
    }
}
