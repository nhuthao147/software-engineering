package com.example.demo.service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDAO;
import com.example.demo.entities.User;


@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserRepository userRepository;
	
	public User loadUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public boolean checkLogin(User userForm) {
		return userDAO.checkLogin(userForm);
	}

	public int changePassword(String username, String password){
		return userDAO.changePassword(username, password);}
}
