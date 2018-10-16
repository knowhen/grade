package com.when.tdd.caculate_grade;

import java.time.LocalDate;

public abstract class GradeNumber {
	abstract int getGraduateGradeNumber();
	
	abstract int getEntranceGradeNumber();

	public LocalDate caculateGraduateDate(Student student) {
		int yearsToGraduate = getGraduateGradeNumber() - student.getGradeNumber();
		int year = student.getEntranceDate().getYear() + yearsToGraduate;
		return LocalDate.of(year, 9, 1);
	}
	
}
