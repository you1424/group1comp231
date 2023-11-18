package com.yuichi.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.yuichi.spring.mvc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT e FROM Employee e WHERE e.userName = ?1 AND e.password = ?2" )
	Employee findForLogin(String username, String password);
	
	
}
