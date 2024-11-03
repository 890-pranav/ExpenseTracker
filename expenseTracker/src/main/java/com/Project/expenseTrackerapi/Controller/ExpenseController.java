package com.Project.expenseTrackerapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.expenseTrackerapi.entity.Expense;
import com.Project.expenseTrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
}
