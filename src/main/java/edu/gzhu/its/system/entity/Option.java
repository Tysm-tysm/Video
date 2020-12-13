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
@Table(name = "option_Tab")
public class Option {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OptionId;
	
	@Column(name = "option_name")
    private String option_name;
    private int option_type;
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "question_id")
    private Questuin question;//对应一端（Question中mappedBy的值）
    
    //option_answer
    @OneToMany(mappedBy = "option_answer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    mappedBy="author"中的author是Article中的author属性
//    mappedBy表示声明自己不是一对多的关系维护端，由对方来维护，是在一的一方进行声明的。
//    mappedBy的值应该为一的一方的表名。在JPA中，在@OneToMany里加入mappedBy属性可以避免生成一张中间表。
    private List<Answer> optionList;//Answer表中選同一選項的用戶
    
    
	public Questuin getQuestion() {
		return question;
	}
	
	@JsonBackReference
	public void setQuestion(Questuin question) {
		this.question = question;
	}
	
	public long getId() {
		return OptionId;
	}
	public void setId(long id) {
		OptionId = id;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public int getOption_type() {
		return option_type;
	}
	public void setOption_type(int option_type) {
		this.option_type = option_type;
	}

}
