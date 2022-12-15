package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "http://localhost:3001")
public class StudentRESTController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/students",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Student> getStudents(){
		List<Student> list = studentService.getAllStudents();
		return list;
	}

	@RequestMapping(value = "/students/{stuId}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Student getStudent(@PathVariable("stuId") Long stuId){
		return studentService.getStudent(stuId);
	}

	@RequestMapping(value = "/students",
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Student addStudent(@RequestBody Student stuForm){
		System.out.println("(Service Side) Creating student with studentId: " + stuForm.getStudentId());
		return studentService.addStudent(stuForm);
	}

	@RequestMapping(value = "/students",
			method = RequestMethod.PUT,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Student updateStudent(@RequestBody Student stuForm){
		System.out.println("(Service Side) Editing student with studentId: " + stuForm.getStudentId());
		return studentService.updateStudent(stuForm);
	}
	
	@RequestMapping(value = "/students/{stuId}",
			method = RequestMethod.DELETE,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String deleteStudent(@PathVariable("stuId") Long stuId){
		System.out.println("(Service Side) Deleting student with Id: " + stuId);
		studentService.deleteStudent(stuId);
		return "Delete successful";
	}
}
