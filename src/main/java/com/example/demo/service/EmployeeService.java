package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entities.Employee;


@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public Employee getEmployee(Long empId) {
		return employeeDAO.getEmployee(empId);
	}
	
	public Employee addEmployee (Employee employee) {
		return employeeDAO.addEmployee(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeDAO.updateYmployee(employee);
	}
	
	public void deleteEmployee (Long empId) {
		employeeDAO.deleteEmployee(empId);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployee();
	}
}
