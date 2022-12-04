package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String password;
	private String rolename;

	@OneToOne(mappedBy = "users")
	private Student student;

	@OneToOne(mappedBy = "users")
	private Instructor instructor;

	public User(final String username,final String password,final String rolename) {
		super();
		this.username = username;
		this.password = password;
		this.rolename = rolename;
	}
	
	public User(int id, String username, String password, String rolename) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rolename = rolename;
	}

	public User() {
		super();
	}

	@Transient
	public List<GrantedAuthority> getAuthorities () {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(getRolename()));
		return authorities;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, length = 45)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "rolename")
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}

