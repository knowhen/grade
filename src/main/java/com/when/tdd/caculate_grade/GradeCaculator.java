package com.when.tdd.caculate_grade;

import java.time.LocalDate;

public class GradeCaculator {

	public String caculate(Student student, LocalDate date) {
		checkEntranceDate(student.getEntranceDate(), date);
		checkGraduateDate(student.getGraduateDate(), date);
		return student.getGradeName();
	}
	
	private void checkEntranceDate(LocalDate entranceDate, LocalDate date) {
		if (date.isBefore(entranceDate)) {
			throw new IllegalArgumentException("Student is not enrolled");
		}
	}

	private void checkGraduateDate(LocalDate graduateDate, LocalDate date) {
		if (date.isAfter(graduateDate)) {
			throw new IllegalArgumentException("Student graduated from school");
		}
	}

}
