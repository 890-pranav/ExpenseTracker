package com.Project.expenseTrackerapi.Controller;


import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.expenseTrackerapi.entity.Expense;
import com.Project.expenseTrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expenses")
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page);
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
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@PathVariable Long id,@RequestBody Expense expense) {
		return expenseService.updateExpenseDetails(id, expense);
	}
	@GetMapping("/expenses/category")
	public List<Expense> getExpenseByCategory(@RequestParam String category,Pageable page){
		return expenseService.readByCategory(category, page);
	}
	@GetMapping("/expenses/name")
	public List<Expense> getExpenseByName(@RequestParam String keyword,Pageable page){
		return expenseService.readByName(keyword, page);
	}
	@GetMapping("/expenses/date")
	public List<Expense> getExpenseByDates(@RequestParam(required = false) Date startDate,@RequestParam(required=false) Date endDate,Pageable page){
		return expenseService.readByDate(startDate, endDate, page);
	}
}
