package com.Project.expenseTrackerapi.service;

import com.Project.expenseTrackerapi.entity.User;
import com.Project.expenseTrackerapi.entity.UserModel;

public interface UserService {
	User createUser(UserModel user);
	User readUser(Long id);
	User updateUser(UserModel user,Long id);
	void deleteUser(Long id);
}
