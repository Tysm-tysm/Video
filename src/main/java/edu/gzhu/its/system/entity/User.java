package edu.gzhu.its.system.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "its_name")
public class User {
	/**
	 * @id表示主鍵
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)表示主鍵的生成策略
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Userid;
	
	@Column(name = "username",unique = true)
    private String username;
	private int userIdentity;//0代表普通用户，1代表管理员
    private String password;
    private String sex;
    private String qq;
    private String email;
    private String tel;
	private String school;
    private String major;
    private Date birth;
    
    @OneToMany(mappedBy = "user_answer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Answer> userAnswers;//用戶答案列表
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public long getId() {
		return Userid;
	}
	
	public int getUserIdentity() {
		return userIdentity;
	}
	public void setUserIdentity(int userIdentity) {
		this.userIdentity = userIdentity;
	}
	public void setId(long id) {
		this.Userid = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public long getUserid() {
		return Userid;
	}
	public void setUserid(long userid) {
		Userid = userid;
	}
	public List<Answer> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(List<Answer> userAnswers) {
		this.userAnswers = userAnswers;
	}
	@Override
	public String toString() {
		return "User [id=" + Userid + ", username=" + username + ", password=" + password + ", sex=" + sex + ", email="
				+ email + ", tel=" + tel + ", school=" + school + ", major=" + major + ", birth=" + birth + "]";
	}
	

}
