package com.Project.expenseTrackerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.expenseTrackerapi.entity.User;

@Repository  //JPARepo already has @Repository annotation so no need to add
public interface UserRepository extends JpaRepository<User, Long> {

	Boolean existsByEmail(String email);
}
