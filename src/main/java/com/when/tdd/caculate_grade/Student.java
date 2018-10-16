package com.when.tdd.caculate_grade;

import java.time.LocalDate;

public class Student {
	private int gradeNumber;
	private String gradeName;
	private School school;
	private LocalDate entranceDate;
	private LocalDate graduateDate;
	
	
	public Student() {
	}

	public Student(LocalDate entranceDate, int gradeNumber, School school) {
		this.entranceDate = entranceDate;
		this.gradeNumber = gradeNumber;
		this.school = school;
		setGraduateDate();
		setGradeName();
	}

	public LocalDate getEntranceDate() {
		return entranceDate;
	}

	public int getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	public void setEntranceDate(LocalDate entranceDate) {
		this.entranceDate = entranceDate;
	}

	public LocalDate getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate() {
		this.graduateDate = school.caculateGraduateDate(this);
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public void setGradeName() {
		this.gradeName = school.getGradeName(this);
	}

	public String getGradeName() {
		return gradeName;
	}
	
}
