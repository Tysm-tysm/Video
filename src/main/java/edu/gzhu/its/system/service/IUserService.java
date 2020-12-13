package edu.gzhu.its.system.service;

import java.util.List;

import edu.gzhu.its.system.entity.User;

public interface IUserService {
	
	public List <User> findAll();
	
	public void saveUser(User user) throws Exception; 
	
	public void deleteUser(User user);
	
	public void updateUserMajor(Long userId,String major );//根據用戶的id更改專業
	
	public User getUserByUsername(String username);//根據用戶名來查詢用戶
	
	public User getUserByUsernameAndPassword(String username,String password);//根據用戶名和密碼來查詢用戶
	
	public boolean checkUser(String username,String password);//根據用戶名和密碼校驗用戶
	
	public boolean isNeedCompleteQQ(User user);//是否要求完善qq
	
	public List<User> findUserByUserName(String username);//根據用戶名模糊查詢相互其中，'%   %'是關鍵，但在jpa中用%username%
	
	public List<User> findUserByMajor1(String major);
	
	public List<User> findUserByMajor2(String major);


}
