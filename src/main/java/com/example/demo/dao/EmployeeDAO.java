package com.example.demo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;



@Repository
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee getEmployee(Long empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, empId);
		return emp;
	}
	
	public Employee addEmployee(Employee empForm) {
		Session session = sessionFactory.getCurrentSession();
		session.save(empForm);
		return empForm;
	}
	
	public Employee updateYmployee(Employee empForm) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, empForm.getEmpId());
		emp.setEmpName(empForm.getEmpName());
		emp.setEmpNo(empForm.getEmpNo());
		session.update(emp);
		return emp;
	}
	
	public void deleteEmployee(Long empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, empId);
		session.delete(emp);
	}
	
	public List<Employee> getAllEmployee(){
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> listEmployee = session.createQuery(" FROM " + Employee.class.getName()).list();
		return listEmployee;
	}
}
