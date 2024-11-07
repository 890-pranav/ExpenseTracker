package com.Project.expenseTrackerapi.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserModel {
	@NotBlank(message = "Name should not be null")
	private String name;
	
	@NotNull(message = "Email should not be null")
	@Email(message = "Enter valid email")
	private String email;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 5, message = "Password should be atleast 5 charachters")
	private String password;
	
	private Long age=0L;
	
	public UserModel() {
		super();
	}

	public UserModel(String name, String email, String password, Long age) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

}
