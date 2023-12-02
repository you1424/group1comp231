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

	@PostMapping("/login")
	public String loginToDepartmentForm(Model model, @RequestParam String userName, @RequestParam String password) {
	    // get login info from database
	    Employee employee = employeeRepository.findForLogin(userName, password);

	    if (employee != null) {
	        // set user information
	        model.addAttribute("firstName", employee.getFirstName());
	        model.addAttribute("lastName", employee.getLastName());

	        // redirect to dash board based by department and grade
	        String dashboard = getDashboardForEmployee(employee);
	        return dashboard != null ? dashboard : "EmployeeForm";
	    } else {
	        // when fail log-in
	        return "LoginFailed";
	    }
	}

	//  get dash board based by employee's department and grade
	private String getDashboardForEmployee(Employee employee) {
	    String department = getDepartmentName(employee.getDepartmentId());
	    String grade = getGradeName(employee.getGradeId());

	    // generate dash board name with department and grade
	    String dashboard = department + grade + "Dashboard";
	    if (isValidDashboard(dashboard)) {
	        return dashboard;
	    }

	    // Default dash board if no specific department or job title is specified
	    return "EmployeeForm";
	}

	// Method to get department name from department ID
	private String getDepartmentName(int departmentId) {
		// Implement the logic to get the department name from the database
		// In the actual project, add logic to retrieve from the database
	    switch (departmentId) {
	        case 1:
	            return "Hr";
	        case 2:
	            return "Accounting";
	        case 3:
	            return "It";
	        case 4:
	            return "Business";
	        default:
	            return "Unknown";
	    }
	}

	// Method to get the job title from the job title value
	private String getGradeName(int grade) {
		// Implement logic to retrieve job title from database
	    switch (grade) {
	        case 1:
	            return "";
	        case 2:
	            return "Supervisor";
	        case 3:
	            return "Manager";
	        case 4:
	            return "Administrator";
	        default:
	            return "Unknown";
	    }
	}
	
	// Method to check if dash board exists
	private boolean isValidDashboard(String dashboard) {
		// Implement logic to check if dash board exists
	    return true;
	}

	   
	}


