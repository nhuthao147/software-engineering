package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/rest")
public class UserRestController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;


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
