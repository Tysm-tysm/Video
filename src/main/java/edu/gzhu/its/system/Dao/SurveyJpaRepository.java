package edu.gzhu.its.system.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.gzhu.its.system.entity.Survey;


public interface SurveyJpaRepository extends JpaRepository<Survey, Long> {

}
