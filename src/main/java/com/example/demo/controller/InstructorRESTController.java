package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Instructor;
import com.example.demo.service.InstructorService;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = {"http://localhost:3001", "https://software-engineering-kjob.vercel.app"})
public class InstructorRESTController {
	@Autowired
	private InstructorService instructorService;
	
	@RequestMapping(value = "/instructors",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Instructor> getInstructors(){
		List<Instructor> list = instructorService.getAllInstructors();
		return list;
	}

	@RequestMapping(value = "/instructors/{insId}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Instructor getInstructor(@PathVariable("insId") Long insId){
		return instructorService.getInstructor(insId);
	}

	@RequestMapping(value = "/instructors",
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Instructor addInstructor(@RequestBody Instructor insForm){
		System.out.println("(Service Side) Creating instructor with instructorId: " + insForm.getInstructor_id());
		insForm.setInstructor_id("GV");
		return instructorService.addInstructor(insForm);
	}

	@RequestMapping(value = "/instructors",
			method = RequestMethod.PUT,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Instructor updateInstructor(@RequestBody Instructor insForm){
		System.out.println("(Service Side) Editing instructor with instructorId: " + insForm.getInstructor_id());
		return instructorService.updateInstructor(insForm);
	}
	
	@RequestMapping(value = "/instructors/{insId}",
			method = RequestMethod.DELETE,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String deleteInstructor(@PathVariable("insId") Long insId){
		System.out.println("(Service Side) Deleting instructor with Id: " + insId);
		instructorService.deleteInstructor(insId);
		return "Delete successful";
	}

	@RequestMapping(value = "/instructors/find",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Instructor> getInstructorByName(@RequestBody Instructor instructor){
		return instructorService.findInstructorsByNameContaining(instructor.getName());
	}

}
