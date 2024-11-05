package com.Project.expenseTrackerapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id) {
		return expenseService.getExpenseById(id);
	}
	@DeleteMapping("/expenses/{id}")
	public void deleteExpenseById(@PathVariable Long id) {
		expenseService.deleteExpenseById(id);
	}
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@PathVariable Long id,@RequestBody Expense expense) {
		return expenseService.updateExpenseDetails(id, expense);
	}
}
