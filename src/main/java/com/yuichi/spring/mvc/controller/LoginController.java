package com.yuichi.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuichi.spring.mvc.model.Employee;
import com.yuichi.spring.mvc.repository.EmployeeRepository;

@Controller
public class LoginController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	private String userName;
	

//Home	
	@GetMapping("/") // URL , which is just rout, not address. this rout to index which is returned.
	public String displayIndex(Model model) { // return type is String// method name you can create. this method doesn't
												// call from anywhere in this code. it called by server.
		Employee employee = new Employee(); 
		model.addAttribute("employee", employee);
												
		return "Home"; // the destination. this shows index page, when "/" called
	}
//toLodinForm
	@GetMapping("/toLoginForm")//name the rout(URL)
	public String displayLoginForm(Model model) {//model is for display thing to this page
		Employee employee = new Employee(); 
		model.addAttribute("employee", employee);
		return "LoginForm";
	}

	@PostMapping("/toEmployeeForm")
	public String loginToEmployeeForm(Model model, @ModelAttribute Employee tempEmployee) {
	    Employee employee = employeeRepository.findForLogin(tempEmployee.getUserName(), tempEmployee.getPassword()); 
	    if (employee != null) {
	        userName = employee.getUserName();
	        model.addAttribute("firstName", employee.getFirstName());
	        model.addAttribute("lastName", employee.getLastName());

	        // To change the html by depertmentID
	        switch (employee.getDepartmentId()) {
		        case 1:
		            return "redirect:/hrDashboard"; // HR
		        case 2:
		            return "redirect:/accountingDashboard"; // Accounting
		        case 3:
		            return "redirect:/itDashboard"; // IT
		        case 4:
		            return "redirect:/businessDashboard"; // Business
		        default:
		            return "EmployeeForm"; // EmployeeForm Defo
	    }
	    } else {
	        // file login
	        return "LoginFailed"; // 
	    }
	}

}
