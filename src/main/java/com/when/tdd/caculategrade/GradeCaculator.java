package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class GradeCaculator {

	public String getCurrentGradeName(Student student, School school) {
		return getGradeNameOfDate(student, school, LocalDate.now());
	}

	public String getGradeNameOfDate(Student student, School school, LocalDate date) {
		checkEntranceDate(student.getEntranceDate(), date);
		checkGraduateDate(school.caculateGraduateGradeDate(student), date);
		return school.getGradeNameOfDate(student.getEntranceDate(), student.getGradeNumber(), date);
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
