package edu.gzhu.its.system.service.jmpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.gzhu.its.system.Dao.OptionJpaRepository;
import edu.gzhu.its.system.Dao.QuestionJpaRepository;
import edu.gzhu.its.system.Dao.SurveyJpaRepository;
import edu.gzhu.its.system.entity.Option;
import edu.gzhu.its.system.entity.Questuin;
import edu.gzhu.its.system.entity.Survey;
import edu.gzhu.its.system.service.ISurveyService;

@Service("surveyService")
@Transactional
public class SurveyService implements ISurveyService {
	
	@Resource
	private SurveyJpaRepository surveyJpaRepository;
	
	@Resource
	private OptionJpaRepository optionJpaRepository;
	
	@Resource
	private QuestionJpaRepository questionJpaRepository;

	@Override
	public void saveQuestion(Questuin questuin) throws Exception {
		// TODO Auto-generated method stub
		this.questionJpaRepository.save(questuin);

	}
	
	@Override
	public void saveOption(Option option) throws Exception {
		// TODO Auto-generated method stub
		this.optionJpaRepository.save(option);

	}
	
	@Override
	public void saveSurvey(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		this.surveyJpaRepository.save(survey);

	}

}
