package com.example.householdbudget.controller.summary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/summary")
public class SummaryController {
    
    @GetMapping("/monthly")
    public String summary() {
        return "summary/monthly";
    }
}
