package edu.gzhu.its.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.gzhu.its.system.entity.User;
import edu.gzhu.its.system.service.IUserService;


@Controller
public class LoginController {
	
	@Resource
	private HttpSession httpSession; 
	
	@Resource
	private IUserService userService;
	//通過接口形式注入userService
	
	@GetMapping("/login")
	public String login(Integer status, Model model) {
		if (status != null) {
			if (status == 1) {
				model.addAttribute("message", "用戶名或密碼錯誤");
			}
			if (status == 2) {
				model.addAttribute("message", "用戶登錄失效");
			}
			if (status == 3) {
				model.addAttribute("message", "用戶退出成功");
			}
		}

		return "login";
	}
	
	@GetMapping("/loginOut")
	public String loginOut() {
		//將currentUser置爲null
		httpSession.setAttribute("currentUser", null);
		return "redirect:/login?status=3";
	}

	@PostMapping("/doLogin")
	public String doLogin(User user,Model model) {
		
		User user1=this.userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(user1!=null) {
			httpSession.setAttribute("currentUser", user1);
			if(user1.getUserIdentity()==1) {
				return "redirect:/admin";
			}
			else {
				return "redirect:/user/index";
			}
		}
		else {
			/*model.addAttribute("message","用戶名或密碼錯誤!");
			return "login";*/
			return "redirect:/login?status=1";
		}
		
	}
}
