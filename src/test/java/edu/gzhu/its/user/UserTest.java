package edu.gzhu.its.user;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import edu.gzhu.its.system.entity.User;
import edu.gzhu.its.system.service.jmpl.UserService;

@RunWith(SpringRunner.class)//表示spring 的測試
@SpringBootTest//表示spring boot的測試

public class UserTest {
	
	@Resource
	public UserService userService;
	
	@Test
	public void UpdateUser() throws Exception{
		this.userService.updateUserMajor(10l, "計算機");
	}
	
	@Test
	public void getUserByUsername() throws Exception {
		User user = this.userService.getUserByUsername("admin1");
		System.out.print(user.toString());
	}

	
	@Test
	public void findUserByMajor() throws Exception {
		List<User> users1=this.userService.findUserByMajor1("計科");
		System.out.print(users1.size());
		List<User> users2=this.userService.findUserByMajor2("計算機");
		System.out.print(users2.size());
	}



}
