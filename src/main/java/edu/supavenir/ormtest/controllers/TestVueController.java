package edu.supavenir.ormtest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestVueController {
	
	@GetMapping("/vue")
	public String testVue() {
		return "vueIndex";
	}
	
	@GetMapping("/users")
	public String usersAction() {
		return "vueUsers";
	}
}
