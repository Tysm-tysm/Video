package edu.gzhu.its.web;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.gzhu.its.system.entity.Option;
import edu.gzhu.its.system.entity.Questuin;
import edu.gzhu.its.system.entity.Survey;
import edu.gzhu.its.system.service.jmpl.SurveyService;

@Controller
@RequestMapping("/survey")
public class surveyController {
	
	@Resource
	private SurveyService surveyService;


	
	@Resource
	private HttpSession httpSession; 
	
	@PostMapping("/saveSurvey")//保存用户调查信息
	//	public String saveQuestuin(Questuin question,String[] option_name,Survey survey) throws Exception {
	public String saveQuestuin(Questuin question,Survey survey) throws Exception {
		question.setSurvey(survey);
		surveyService.saveSurvey(survey);
		surveyService.saveQuestion(question);
		/*for(int i=0;i<option_name.length;i++) {
			Option option=new Option();
			option.setOption_name(option_name[i]);
			option.setQuestion(question);
			surveyService.saveSurvey(option);
		}*/
		return "user/userSurvey";
	}
	
	
	@PostMapping("/saveOption")
	public String saveOption(Option option) throws Exception {
	    surveyService.saveOption(option);
		return "";
	}
}
