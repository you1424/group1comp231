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
@Table(name = "grade")
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gradeid")
	@NotNull(message = "gradeid ID is mandatory")
	private int gradeId;
	@Column(name = "positionname")
	@NotBlank(message = "Positionname is mandatory")
	private String positionName;
	@Column(name = "salarypoint")
	@NotBlank(message = "Salarypoint is mandatory")
	private double salaryPoint;

	public Grade(int gradeId, String positionName, double salaryPoint) {
		this.gradeId = gradeId;
		this.positionName = positionName;
		this.salaryPoint = salaryPoint;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public double getSalaryPoint() {
		return salaryPoint;
	}

	public void setSalaryPoint(double salaryPoint) {
		this.salaryPoint = salaryPoint;
	}

	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", positionName=" + positionName + ", salaryPoint=" + salaryPoint
				+ ", getGradeId()=" + getGradeId() + ", getPositionName()=" + getPositionName() + ", getSalaryPoint()="
				+ getSalaryPoint() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
