package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = {"http://localhost:3001", "https://software-engineering-kjob.vercel.app"})
public class MainController {
	
	@RequestMapping("/")
	public String home() {
	return "index";
	}

}


