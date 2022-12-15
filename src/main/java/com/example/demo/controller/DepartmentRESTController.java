package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "http://localhost:3001")
public class DepartmentRESTController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/departments",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Department> getDepartments(){
		List<Department> list = departmentService.getAllDepartments();
		return list;
	}
	
	@RequestMapping(value = "/departments",
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Department addDepartment(@RequestBody Department depForm){
		System.out.println("(Service Side) Creating department with departmentId: " + depForm.getDepartment_id());
		return departmentService.addDepartment(depForm);
	}

	@RequestMapping(value = "/departments",
			method = RequestMethod.PUT,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Department updateDepartment(@RequestBody Department depForm){
		System.out.println("(Service Side) Editing department with departmentId: " + depForm.getDepartment_id());
		return departmentService.updateDepartment(depForm);
	}
	
	@RequestMapping(value = "/departments/{depId}",
			method = RequestMethod.DELETE,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String deleteDepartment(@PathVariable("depId") Long depId){
		System.out.println("(Service Side) Deleting department with Id: " + depId);
		departmentService.deleteDepartment(depId);
		return "Delete successful";
	}

	@RequestMapping(value = "/departments/{depId}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Department getDepartment(@PathVariable("depId") Long depId){
		return departmentService.getDepartment(depId);
	}

}
