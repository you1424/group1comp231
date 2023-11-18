package com.yuichi.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuichi.spring.mvc.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
//	@Query("SELECT d FROM Department d WHERE d.departmentId = ?1" )
//	Department findById(int departmentid);

}
