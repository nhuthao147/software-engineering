package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.dto.LoginResult;
import com.example.demo.dto.UserProfile;
import com.example.demo.entities.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3001", "https://software-engineering-kjob.vercel.app"})
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

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private JoinRequestService joinRequestService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<LoginResult> login(HttpServletRequest request, @RequestBody User user){
		String result = "";
		HttpStatus httpStatus = null;
		LoginResult loginResult = new LoginResult();
		try {
			if(userService.checkLogin(user)) {
				loginResult.setStatus(true);
				loginResult.setToken(jwtService.generateTokenLogin(user.getUsername()));
				httpStatus = HttpStatus.OK;
			} else {
				loginResult.setStatus(false);
				loginResult.setToken("Wrong userId and password");
				httpStatus = HttpStatus.OK;
			} 
		}catch(Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<LoginResult>(loginResult, httpStatus);
	}
//
//	@RequestMapping(value = "/options",
//			method = RequestMethod.GET,
//			produces = {MediaType.APPLICATION_JSON_VALUE,
//					MediaType.APPLICATION_XML_VALUE})
//	@ResponseBody
//	public List<String> getInstructor(@RequestHeader ("Authorization") String token){
//		String role = userService.loadUserByUsername(jwtService.getUsernameFromToken(token)).getRolename() ;
//		List<String> list = new ArrayList<String>();
//		if (role.equals("ROLE_ADMIN")){
//			list.add("QUAN_LY_TAI_KHOAN");
//			list.add("IMPORT_FILE");
//			list.add("POST_THONG_BAO");
//		}
//		else if (role.equals("ROLE_USER")){
//
//		}
//		return list;
//	}

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
			userProfile.setTopicid(topicService.getTopic(joinRequestService.findUserByStatusAndNameNamedParams(student.getId()).getId()).getId().toString());
			userProfile.setUser_id(student.getStudentId());
			userProfile.setDepartmentid(student.getDepartments().getDepartment_id());

			return userProfile;
		}
		else if (role.equals("ROLE_INSTRUCTOR")){
			listFunction.add("DANH_GIA_DE_TAI");
			listFunction.add("DANG_KY_DE_TAI");

			Instructor instructor = instructorService.findUserByStatusAndNameNamedParams(username);
			userProfile.setRole(role);
			userProfile.setBirthday(instructor.getBirthday());
			userProfile.setFunction(listFunction);
			userProfile.setBirthday(instructor.getBirthday());
			userProfile.setName(instructor.getName());
			userProfile.setUsername(username);
			userProfile.setStart_day(instructor.getStart_day());
			userProfile.setEnd_day(instructor.getEnd_day());
			userProfile.setUser_id(instructor.getInstructor_id());
			userProfile.setDepartmentid(instructor.getDepartments().getDepartment_id());

			return userProfile;
		}
		else if (role.equals("ROLE_HEAD")){
			listFunction.add("QUAN_LY_DE_TAI");
			listFunction.add("DANH_GIA_DE_TAI");
			listFunction.add("PHAN_CONG_DANH_GIA_DE_TAI");
			listFunction.add("PHE_DUYET_DE_TAI");
			listFunction.add("POST_THONG_BAO");


//			List<String> heads = departmentService.getAllDepartments().stream().map(d->d.getHead_id()).toList();

			Instructor instructor = instructorService.findUserByStatusAndNameNamedParams(username);
			userProfile.setRole(role);
			userProfile.setBirthday(instructor.getBirthday());
			userProfile.setFunction(listFunction);
			userProfile.setBirthday(instructor.getBirthday());
			userProfile.setName(instructor.getName());
			userProfile.setUsername(username);
			userProfile.setStart_day(instructor.getStart_day());
			userProfile.setEnd_day(instructor.getEnd_day());
			userProfile.setUser_id(instructor.getInstructor_id());
			userProfile.setDepartmentid(instructor.getDepartments().getDepartment_id());

			return userProfile;
		}
		return userProfile;
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
