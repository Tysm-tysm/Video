package edu.gzhu.its.system.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.gzhu.its.system.entity.Questuin;

public interface QuestionJpaRepository extends JpaRepository<Questuin, Long> {

}
