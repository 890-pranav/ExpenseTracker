package com.Project.expenseTrackerapi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Project.expenseTrackerapi.entity.Expense;
import com.Project.expenseTrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

}
