package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;



@RestController
@RequestMapping("/rest")
public class EmployeeRESTController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employees",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Employee> getEmployees(){
		List<Employee> list = employeeService.getAllEmployees();
		return list;
	}

	@RequestMapping(value = "/employees/{empId}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee getEmployee(@PathVariable("empId") Long empId){
		return employeeService.getEmployee(empId);
	}

	@RequestMapping(value = "/employees",
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee empForm){
		System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo());
		return employeeService.addEmployee(empForm);
	}

	@RequestMapping(value = "/employees",
			method = RequestMethod.PUT,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee updateEmployee(@RequestBody Employee empForm){
		System.out.println("(Service Side) Editing employee with empNo: " + empForm.getEmpNo());
		return employeeService.updateEmployee(empForm);
	}
	
	@RequestMapping(value = "/employees/{empId}",
			method = RequestMethod.DELETE,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String updateEmployee(@PathVariable("empId") Long empId){
		System.out.println("(Service Side) Deleting employee with Id: " + empId);
		employeeService.deleteEmployee(empId);
		return "Delete successful";
	}
}

