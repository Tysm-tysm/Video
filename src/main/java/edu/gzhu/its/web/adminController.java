package edu.gzhu.its.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.gzhu.its.system.entity.User;

@Controller
public class adminController {
	
	
	@Resource
	private HttpSession httpSession;
	
	@GetMapping("/admin")
	public String admin() {
		User user=(User) httpSession.getAttribute("currentUser");
		if(user==null) {
			return "redirect:/login?status=2";
		}
		else {
			return "admin/index";
		}
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	
	@GetMapping("/survey/research")
	public String research(){
		return "survey/research";
	}
	
	@GetMapping("/survey/Create")
	public String Create(){
		return "survey/Create";
	}
	
	@GetMapping("/survey/result")
	public String result(){
		return "survey/result";
	}



}
