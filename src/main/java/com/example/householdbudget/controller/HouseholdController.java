package com.example.householdbudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/household")
public class HouseholdController {

    @GetMapping("/list")
    public String list() {
        return "household/list";
    }
}
