package edu.gzhu.its.system.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "Question_Tab")
public class Questuin {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long QuestionId;
	
	@Column(name = "Question_title")
    private String question_title;
    private int question_type;
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "survey_id")
    private Survey survey;
    
	@OneToMany(mappedBy = "question" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)//mappedBy表示声明自己不是一对多的关系维护端，由对方来维护，是在一的一方进行声明的。mappedBy的值应该为一的一方的表名。
    private java.util.List<Option> optionList;//問題選項列表
//  mappedBy="question"中的question是Option中的question属性（去option表中看看就好了）	
//  mappedBy表示声明自己不是一对多的关系维护端，由对方来维护，是在一的一方进行声明的。多端进行维护
//  mappedBy的值应该为一的一方的表名。在JPA中，在@OneToMany里加入mappedBy属性可以避免生成一张中间表。
    
    @OneToMany(mappedBy = "question_answer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Answer> answerList;//針對該問題的所有作答者的答案
    
    
    public Survey getSurvey() {
		return survey;
	}
    
    @JsonBackReference
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public long getId() {
		return QuestionId;
	}
	public void setId(long id) {
		QuestionId = id;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public int getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(int question_type) {
		this.question_type = question_type;
	}

}
