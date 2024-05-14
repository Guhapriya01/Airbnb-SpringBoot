package com.priya.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping({"/","/home"})
	public String getHomePage() {
		return "index.jsp";
	}
	
	@GetMapping("/admin")
	public String getAdminPage() {
		return "admin.jsp";
	}
	
	@GetMapping("/alogout")
	public String adminLogout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/";
	}	
}
