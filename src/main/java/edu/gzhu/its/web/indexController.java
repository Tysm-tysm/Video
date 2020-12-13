package edu.gzhu.its.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
//	主頁入口
	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
