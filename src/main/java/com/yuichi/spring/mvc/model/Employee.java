package com.yuichi.spring.mvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank; // I had error, because of the dependency in pom.xml
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	@NotNull(message = "Employee ID is mandatory")
	private int empId;
	@Column(name = "username")
	@NotBlank(message = "Username is mandatory")
	private String userName;
	@Column(name = "firstname")
	@NotBlank(message = "Firstname is mandatory")
	private String firstName;
	@Column(name = "lastname")
	@NotBlank(message = "Lastname is mandatory")
	private String lastName;
	@Column(name = "gradeid")
	@NotNull(message = "GradeId is mandatory")
	private int gradeId;
	@Column(name = "departmentid")
	@NotNull(message = "DepartmentId is mandatory")
	private int departmentId;
	@Column(name = "password")
	@NotBlank(message = "PasswordId is mandatory")
	private String password;
	@Column(name = "hour")
	private double hour;

	public Employee() {

	}

	public Employee(int empId, String userName, String firstName, String lastName, int gradeId, int departmentId,
			String password, double hour) {
		this.empId = empId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeId = gradeId;
		this.departmentId = departmentId;
		this.password = password;
		this.hour = hour;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gradeId=" + gradeId + ", departmentId=" + departmentId + ", password=" + password
				+ ", hour=" + hour + ", getEmpId()=" + getEmpId() + ", getUserName()=" + getUserName()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getGradeId()="
				+ getGradeId() + ", getDepartmentId()=" + getDepartmentId() + ", getPassword()=" + getPassword()
				+ ", getHour()=" + getHour() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	};

}