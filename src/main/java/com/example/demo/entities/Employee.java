package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long emp_id;
	private String emp_no;
	private String emp_name;
	
	public Employee() {
		super();
	}
	public Employee(Long emp_id, String emp_no, String emp_name) {
		super();
		this.emp_id = emp_id;
		this.emp_no = emp_no;
		this.emp_name = emp_name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id", unique = true, nullable = false)
	public Long getEmpId() {
		return emp_id;
	}
	public void setEmpId(Long emp_id) {
		this.emp_id = emp_id;
	}
	@Column(name = "emp_no", unique = true, nullable = false, length = 10)
	public String getEmpNo() {
		return emp_no;
	}
	public void setEmpNo(String emp_no) {
		this.emp_no = emp_no;
	}
	@Column(name = "emp_name", length = 20)
	public String getEmpName() {
		return emp_name;
	}
	public void setEmpName(String emp_name) {
		this.emp_name = emp_name;
	}
	
}
