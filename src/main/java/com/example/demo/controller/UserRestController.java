package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.dto.UserProfile;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Instructor;
import com.example.demo.entities.Student;
import com.example.demo.service.InstructorService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/rest")
public class UserRestController<T>{

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private InstructorService instructorService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(HttpServletRequest request, @RequestBody User user){
		String result = "";
		HttpStatus httpStatus = null;
		try {
			if(userService.checkLogin(user)) {
				result = jwtService.generateTokenLogin(user.getUsername());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			} 
		}catch(Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}

	@RequestMapping(value = "/options",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<String> getInstructor(@RequestHeader ("Authorization") String token){
		String role = userService.loadUserByUsername(jwtService.getUsernameFromToken(token)).getRolename() ;
		List<String> list = new ArrayList<String>();
		if (role.equals("ROLE_ADMIN")){
			list.add("QUAN_LY_TAI_KHOAN");
			list.add("IMPORT_FILE");
			list.add("POST_THONG_BAO");
		}
		else if (role.equals("ROLE_USER")){

		}
		return list;
	}

	@RequestMapping(value = "/profile",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public UserProfile getProfile(@RequestHeader ("Authorization") String token, ModelMap model){
		String role = userService.loadUserByUsername(jwtService.getUsernameFromToken(token)).getRolename() ;
		String username = jwtService.getUsernameFromToken(token);
		UserProfile userProfile = new UserProfile();
		List<String> listFunction = new ArrayList<String>();
		if (role.equals("ROLE_STUDENT")){
			listFunction.add("QUAN_LY_TAI_KHOAN");
			listFunction.add("IMPORT_FILE");
			listFunction.add("POST_THONG_BAO");

			Student student = studentService.findUserByStatusAndNameNamedParams(username);
			userProfile.setRole(role);
			userProfile.setBirthday(student.getBirthday());
			userProfile.setFunction(listFunction);
			userProfile.setBirthday(student.getBirthday());
			userProfile.setName(student.getName());
			userProfile.setUsername(username);
			userProfile.setStart_day(student.getStartDay());
			userProfile.setEnd_day(student.getEndDay());
			userProfile.setTopicid(student.getTopic().getTopic_id());
			userProfile.setUser_id(student.getStudentId());
			userProfile.setDepartmentid(student.getDepartments().getDepartment_id());

			return userProfile;
		}
		else if (role=="ROLE_INSTRUCTOR"){
			listFunction.add("QUAN_LY_TAI_KHOAN");
			listFunction.add("IMPORT_FILE");
			listFunction.add("POST_THONG_BAO");

//			Instructor instructor = instructorService.findUserByStatusAndNameNamedParams(username);
//			userProfile.setRole(role);
//			userProfile.setBirthday(student.getBirthday());
//			userProfile.setFunction(listFunction);
//			userProfile.setBirthday(student.getBirthday());
//			userProfile.setName(student.getName());
//			userProfile.setUsername(username);
//			userProfile.setStart_day(student.getStartDay());
//			userProfile.setEnd_day(student.getEndDay());
//			userProfile.setTopicid(student.getTopic().getTopic_id());
//			userProfile.setUser_id(student.getStudentId());
//			userProfile.setDepartmentid(student.getDepartments().getDepartment_id());

			return userProfile;
		}
		return new UserProfile();
	}

	@PutMapping(value = "/user")
	public ResponseEntity<String> changePassword( @RequestHeader ("Authorization") String token, @RequestBody User user){
		user.setRolename("ROLE_USER");
		String result = "";
		HttpStatus httpStatus = null;
		try {
			String username = jwtService.getUsernameFromToken(token);
			user.setUsername(username);
			if(!userService.checkLogin(user)) {
					int out = userService.changePassword(user.getUsername(), user.getPassword());
					httpStatus = HttpStatus.OK;
					if(out==1)
						result = "Update successfully!";
					else
						result = "Update failed!";
					return new ResponseEntity<String>(result, httpStatus);
			} else {
				result = "New password must be different from old password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		}catch(Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}
}
