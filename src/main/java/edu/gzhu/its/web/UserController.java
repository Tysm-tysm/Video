package edu.gzhu.its.web;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.gzhu.its.system.entity.User;
import edu.gzhu.its.system.service.jmpl.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	User userSurveyTemp;
	
	@Resource
	private HttpSession httpSession;
	
	@Resource
	public UserService userService;
	
	@Resource
	private HttpServletRequest request;
	
	@GetMapping("index")
	private String userIndex() {
		User user = (User)httpSession.getAttribute("currentUser");
		if(user==null) {
			return "redirect:/login?status=2";
		} 
		else {
			return "user/index";
		}
	}
	
	@GetMapping("/userAdd")//添加用戶
	public String userAdd() {
		return "user/userAdd";
	}
	
	@GetMapping("/userInfo")//用戶信息
	public String getUserInfo(Model model) {
		User user=new User();
		user.setUsername("admin");
		user.setBirth(new Date());
		user.setMajor("計算機科學與技術");
		user.setId(1l);
		user.setSex("女");
		model.addAttribute("user",user);
		request.setAttribute("current", user);//另一種方式
		return "user/userInfo";
	}
	
	@GetMapping("/userList")//用戶列表
	public String userList(){
		return "user/userList";
	}
	
	@PostMapping("/saveUser")//保存用戶信息
	public String saveUser(User user) throws Exception {
		
//		System.out.print(user.getUsername());
		user.setUserIdentity(0);
		userService.saveUser(user);
		return "user/userSurvey";
	}
	
//	@PostMapping("/userSurvey")//保存用戶調查信息
//	public String userSurvey(StaticUserSurvey staticUserSurvey) throws Exception {
//		System.out.print(userSurveyTemp.getPassword());
//		staticUserSurvey.setA_username(userSurveyTemp.getUsername());
//		surveyService.saveUser(staticUserSurvey);
		
//		return "";
//	}
	
}
