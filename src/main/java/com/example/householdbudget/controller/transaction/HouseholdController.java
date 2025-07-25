package com.example.householdbudget.controller.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.householdbudget.model.dto.transaction.CategoryType;
import com.example.householdbudget.model.dto.transaction.TransactionDTO;
import com.example.householdbudget.model.form.transaction.TransactionForm;
import com.example.householdbudget.service.transaction.TransactionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class HouseholdController {

    private final TransactionService service;

    @GetMapping("/list")
    public String list(Model model) {
        var list = service.search().stream().map(TransactionDTO::ToDTO).toList();
        model.addAttribute("transactions", list);
        return "transaction/list";
    }

    @GetMapping("/register")
    public String showCreationForm(@ModelAttribute TransactionForm transactionForm, Model model) {
        model.addAttribute("mode", "REGISTER");
        model.addAttribute("incomeCategories", CategoryType.getIncomeCategories());
        model.addAttribute("expenseCategories", CategoryType.getExpenseCategories());
        return "transaction/form";
    }

    @PostMapping("/register")
    public String create(@Validated TransactionForm transactionForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(transactionForm, model);
        }
        service.create(transactionForm.toEntity());
        return "redirect:/transaction/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        var form = service.findById(id)
                .map(TransactionForm::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("指定されたIDが見つかりません。"));
        model.addAttribute("mode", "UPDATE");
        model.addAttribute("incomeCategories", CategoryType.getIncomeCategories());
        model.addAttribute("expenseCategories", CategoryType.getExpenseCategories());
        model.addAttribute("transactionForm", form);
        return "transaction/form";
    }

    @PutMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, @Validated @ModelAttribute TransactionForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "UPDATE");
            model.addAttribute("incomeCategories", CategoryType.getIncomeCategories());
            model.addAttribute("expenseCategories", CategoryType.getExpenseCategories());
            return "/transaction/form";
        }
        service.update(form.toEntity(id));
        return "redirect:/transaction/list";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        service.delete(id);
        return "redirect:/transaction/list";
    }
}
