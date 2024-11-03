package com.Project.expenseTrackerapi.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

import lombok.*;


@Data //added for having lombok features
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "expense_name")
	private String name;
	private String description;
	
	@Column(name = "expense_amount")
	private BigDecimal amount;
	
	private String category;
	private Date date;
}
