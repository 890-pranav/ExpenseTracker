package com.Project.expenseTrackerapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.expenseTrackerapi.entity.User;
import com.Project.expenseTrackerapi.entity.UserModel;
import com.Project.expenseTrackerapi.exceptions.ItemAlreadyExistsException;
import com.Project.expenseTrackerapi.exceptions.ResourceNotFoundException;
import com.Project.expenseTrackerapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(UserModel user) {
		if(userRepo.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User is already registered by email :"+ user.getEmail());
		}
		User newUser=new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepo.save(newUser);
	}
	
	public User readUser(Long id) {
		return userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found for Id:"+id));
	}

	@Override
	public User updateUser(UserModel user, Long id) {
		User existingUser=readUser(id);
		existingUser.setName(user.getName() != null ? user.getName():existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail():existingUser.getEmail());
		existingUser.setPassword(user.getPassword() != null ? user.getPassword():existingUser.getPassword());
		existingUser.setAge(user.getAge() != null ? user.getAge():existingUser.getAge());
		return userRepo.save(existingUser);
	}
	
	public void deleteUser(Long id) {
		User existingUser=readUser(id);
		userRepo.delete(existingUser);
	}

}
