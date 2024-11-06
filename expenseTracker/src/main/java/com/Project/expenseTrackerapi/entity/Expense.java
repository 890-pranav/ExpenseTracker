package com.Project.expenseTrackerapi.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	@NotNull(message = "Expense name must not be null")
	@NotBlank(message = "Expense cannot be blank")
	@Size(min =3, message = "Expense name must be atleast 3 char")
	private String name;
	private String description;
	
	@Column(name = "expense_amount")
	@NotNull(message = "Amount of an expense cannot be null")
	private BigDecimal amount;
	
	@NotBlank(message = "Category of an expense cannot be blank")
	private String category;
	
	@NotNull(message = "Date of an expense cannot be blank")
	private Date date;
	
	@Column(name = "created_at" , nullable = false , updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	public Expense() {
		super();
	}
	public Expense(Long id, String name, String description, BigDecimal amount, String category, Date date,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
