package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;
import com.rest.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserRepository userrepository;
	
	// retrieve all users from database
		@GetMapping("all")
		public List<User> getAllUser() {
			List<User> user = (List<User>) userrepository.findAll();
			return user;
		}
}
