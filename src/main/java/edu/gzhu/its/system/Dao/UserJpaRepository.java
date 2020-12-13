package edu.gzhu.its.system.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import edu.gzhu.its.system.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long>{

	@Modifying
	@Query("update User set major = ?2 where id= ?1")
	public void updateUserMajor(Long userId,String major );
	
	
	@Query("select u from User u where u.username=?1")
	public User getUserByUsername(String username);
	
	@Query("select u from User u where u.username=?1 and u.password=?2")
	public User getUserByUsernameAndPassword(String username,String password);
	
	@Query("select u from User u where username like %:username%")
	public List<User> findUserByUserName(@Param(value = "username") String username);
	
	@Query("select u from User u where u.major=?1")
	public List<User> findUserByMajor1(String major);
	
	@Query("select u from User u where u.major=:major")
	public List<User> findUserByMajor2(@Param(value = "major")String major);
}
/**
 * dao層的jpa接口,後面的尖括號< >裏面的相當於C++中學的class裏的構造變量，而不是在函數裏面賦值
 * **/
