package edu.gzhu.its.system.entity;

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
@Table(name = "Survey")
public class Survey {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long SurveyId;
	
	@Column(name = "survey_title")
	private String surveyTitle;
	private String Description;
	
	 @OneToMany(mappedBy = "survey" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)//mappedBy表示声明自己不是一对多的关系维护端，由对方来维护，是在一的一方进行声明的。mappedBy的值应该为一的一方的表名。
	 private java.util.List<Questuin> questionList;//問題選項列表

	public long getSurveyId() {
		return SurveyId;
	}

	public void setSurveyId(long surveyId) {
		SurveyId = surveyId;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
