package edu.gzhu.its.system.service.jmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.gzhu.its.system.Dao.UserJpaRepository;
import edu.gzhu.its.system.entity.User;
import edu.gzhu.its.system.service.IUserService;


@Service("userService")
@Transactional
public class UserService implements IUserService{
	
	@Resource
	private UserJpaRepository userJpaRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userJpaRepository.findAll();
	}

	@Override
	public void saveUser(User user) throws Exception{
		// TODO Auto-generated method stub
		this.userJpaRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		this.userJpaRepository.delete(user);
		
	}

	@Override
	public void updateUserMajor(Long userId, String major) {
		this.userJpaRepository.updateUserMajor(userId, major);
	}

	@Override
	public User getUserByUsername(String username) {
		return this.userJpaRepository.getUserByUsername(username);
	}

	@Override
	public boolean checkUser(String username, String password) {
		User user=this.userJpaRepository.getUserByUsername(username);
		boolean isequal=user.getPassword().equals(password);
		if(isequal) {
			return true;
		}
		else {
		    return false;
		}
	}

	@Override
	public boolean isNeedCompleteQQ(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		return this.userJpaRepository.getUserByUsernameAndPassword(username, password);
	}

	@Override
	public List<User> findUserByUserName(String username) {
		return this.userJpaRepository.findUserByUserName(username);
	}

	@Override
	public List<User> findUserByMajor1(String major) {
		return this.userJpaRepository.findUserByMajor1(major);
	}

	@Override
	public List<User> findUserByMajor2(String major) {
		return this.userJpaRepository.findUserByMajor2(major);
	}

	
	
	

}
