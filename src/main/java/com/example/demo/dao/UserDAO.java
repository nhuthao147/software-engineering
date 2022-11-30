package com.example.demo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;



@Repository
public class UserDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User loadUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "FROM User WHERE username = :username";
		Query query = session.createQuery(sql);
		query.setParameter("username", username);
		
		List<User> users = query.list();
		if(users != null && users.size()>0)
			return users.get(0);
		return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean checkLogin(User userForm) {
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "FROM User WHERE username = :username and password = :password";
		Query query = session.createQuery(sql);
		query.setParameter("username", userForm.getUsername());
		query.setParameter("password", userForm.getPassword());
		
		List<User> users = query.list();
		if(users != null && users.size()>0)
			return true;
		return false;
	}
	@Autowired
	private SessionFactory sessionFactory;
	
}
