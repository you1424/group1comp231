package com.yuichi.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuichi.spring.mvc.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{
	
	@Query("SELECT g FROM Grade g WHERE g.gradeId = ?1" )
	Grade findById(int gradeId);

}
