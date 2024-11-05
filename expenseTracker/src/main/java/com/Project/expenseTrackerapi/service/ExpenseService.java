package com.Project.expenseTrackerapi.service;
import java.util.List;
import com.Project.expenseTrackerapi.entity.Expense;

public interface ExpenseService {
	List<Expense> getAllExpenses();
	Expense getExpenseById(Long id);
	void deleteExpenseById(Long id);
	Expense saveExpenseDetails(Expense expense);
	Expense updateExpenseDetails(Long id,Expense expense);
}
