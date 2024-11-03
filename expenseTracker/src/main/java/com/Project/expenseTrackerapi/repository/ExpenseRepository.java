package com.Project.expenseTrackerapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Project.expenseTrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
