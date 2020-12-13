package edu.gzhu.its.system.service;


import edu.gzhu.its.system.entity.Option;
import edu.gzhu.its.system.entity.Questuin;
import edu.gzhu.its.system.entity.Survey;

public interface ISurveyService {
	
	public void saveQuestion(Questuin Questuin) throws Exception; 
	public void saveOption(Option option) throws Exception; 
	public void saveSurvey(Survey survey) throws Exception;

}
