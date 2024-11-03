package com.Project.expenseTrackerapi.service;
import java.util.List;
import com.Project.expenseTrackerapi.entity.Expense;

public interface ExpenseService {
	List<Expense> getAllExpenses();
}
