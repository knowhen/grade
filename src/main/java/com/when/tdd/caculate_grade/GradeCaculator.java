package com.when.tdd.caculate_grade;

import java.time.LocalDate;
import java.time.Period;

public class GradeCaculator {
	
	public String caculate(Student student, School school) {
		checkEntranceDate(student.getEntranceDate());
		LocalDate graduateDate = caculateGraduateDate(school, student);
		checkGraduateDate(graduateDate);
		return getGradeName(student, school);
	}

	private void checkEntranceDate(LocalDate entranceDate) {
		if (null == entranceDate) {
			throw new IllegalArgumentException("Student is out of school");
		}
	}

	private void checkGraduateDate(LocalDate graduateDate) {
		if (LocalDate.now().isAfter(graduateDate)) {
			throw new IllegalArgumentException("Student graduated from school");
		}
	}
	
	private LocalDate caculateGraduateDate(School school, Student student) {
		int yearOfEntrance = student.getEntranceDate().getYear();
		int gradeNumber = student.getGradeNumber();
		// 毕业的年份
		int yearsOfGraduate;
		switch (school.getSchoolType()) {
		case 1:
			yearsOfGraduate = 7 - gradeNumber + yearOfEntrance;
			break;
		case 2:
			yearsOfGraduate = 11 - gradeNumber + yearOfEntrance;
			break;
		case 3:
			yearsOfGraduate = 13 - gradeNumber + yearOfEntrance;
			break;
		default:
			throw new IllegalArgumentException("Illegal school type");
		}
		return LocalDate.of(yearsOfGraduate, 9, 1);
	}
	
	private String getGradeName(Student student, School school) {
		switch (school.getGradeRule()) {
		case 1:
			int currentGradeNumber = getCurrentGradeNumber(student.getEntranceDate(), student.getGradeNumber());
			return getGradeNameFromNumber(currentGradeNumber);
		case 2:
			return getGradeNameFromDate(student.getEntranceDate());
		case 3:
			return getGradeNameFromDate(caculateGraduateDate(school, student));
		default:
			throw new IllegalArgumentException("Illegal school type");
		}
	}

	private int getCurrentGradeNumber(LocalDate entranceDate, int gradeNumber) {
		LocalDate currentDate = LocalDate.now();
		Period period = entranceDate.until(currentDate);
		return gradeNumber + period.getYears();
	}

	private String getGradeNameFromNumber(Integer gradeNumber) {
		for (GradeName gradeName : GradeName.values()) {
			if (gradeName.getGradeNumber() == gradeNumber) {
				return gradeName.name();
			}
		}
		throw new IllegalArgumentException("Unsupported grade number");
	}

	private String getGradeNameFromDate(LocalDate date) {
		return String.valueOf(date.getYear()) + "级";
	}
}
