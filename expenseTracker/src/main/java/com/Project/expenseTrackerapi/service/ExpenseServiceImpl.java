package com.Project.expenseTrackerapi.service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Project.expenseTrackerapi.entity.Expense;
import com.Project.expenseTrackerapi.exceptions.ResourceNotFoundException;
import com.Project.expenseTrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}
	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense=expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Expense not present for the Id "+id);
	}
	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
	}
	@Override 
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);
	}
	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense = getExpenseById(id);
		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
		return expenseRepo.save(existingExpense);
	}
	@Override
	public List<Expense> readByCategory(String category, Pageable page) {
		return expenseRepo.findByCategory(category, page).toList();
	}
	@Override
	public List<Expense> readByName(String name, Pageable page) {
		return expenseRepo.findByNameContaining(name, page).toList();
	}
	@Override
	public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {
		if(null==startDate) {
			startDate=new Date(0);
		}
		if(null==endDate) {
			endDate=new Date(System.currentTimeMillis());
		}
		
		return expenseRepo.findByDateBetween(startDate, endDate, page).toList();
	}

}
