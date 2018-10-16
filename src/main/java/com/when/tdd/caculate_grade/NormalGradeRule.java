package com.when.tdd.caculate_grade;

import java.time.LocalDate;
import java.time.Period;

public class NormalGradeRule extends GradeRule {

	@Override
	public int getGradeRule() {
		return 1;
	}

	public String getGradeName(Student student) {
		int currentGradeNumber = getCurrentGradeNumber(student.getEntranceDate(), student.getGradeNumber());
		return getGradeNameFromNumber(currentGradeNumber);
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
}
