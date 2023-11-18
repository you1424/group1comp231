package com.yuichi.spring.mvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentid")
	@NotNull(message = "department ID is mandatory")
	private int departmentId;
	@Column(name = "departmentname")
	@NotBlank(message = "departmentname is mandatory")
	private String departmentName;
	@Column(name = "basicsalary")
	@NotNull(message = "basicsalary is mandatory")
	private double basicSalary;
	@Column(name = "departmentsize")
	@NotNull(message = "departmentsize is mandatory")
	private int departmentSize;

	public Department(int departmentId, String departmentName, double basicSalary, int departmentSize) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.basicSalary = basicSalary;
		this.departmentSize = departmentSize;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getDepartmentSize() {
		return departmentSize;
	}

	public void setDepartmentSize(int departmentSize) {
		this.departmentSize = departmentSize;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", basicSalary="
				+ basicSalary + ", departmentSize=" + departmentSize + ", getDepartmentId()=" + getDepartmentId()
				+ ", getDepartmentName()=" + getDepartmentName() + ", getBasicSalary()=" + getBasicSalary()
				+ ", getDepartmentSize()=" + getDepartmentSize() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
