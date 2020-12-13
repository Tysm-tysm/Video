package edu.gzhu.its.system.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//generted生成的
    private long Answerid;
	
	//维护端注解
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
	@JoinColumn(name = "user_id")//name:该字段的名称(指定关联关系中的维护端对应的表中和被维护端的主键进行关联的字段的名称)，白话文：name的值要填写维护端的属性
	private User user_answer;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
	@JoinColumn(name = "question_id")
	private Questuin question_answer;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
	@JoinColumn(name = "option_id")
	private Option option_answer;
	
	
	public long getAnswerid() {
		return Answerid;
	}

	public void setAnswerid(long answerid) {
		Answerid = answerid;
	}
	

	public User getUser_answer() {
		return user_answer;
	}
	
	@JsonBackReference
	public void setUser_answer(User user_answer) {
		this.user_answer = user_answer;
	}
	
	public Questuin getQuestion_answer() {
		return question_answer;
	}
	
	@JsonBackReference
	public void setQuestion_answer(Questuin question_answer) {
		this.question_answer = question_answer;
	}
	
	public Option getOption_answer() {
		return option_answer;
	}
	
	@JsonBackReference
	public void setOption_answer(Option option_answer) {
		this.option_answer = option_answer;
	}

}
