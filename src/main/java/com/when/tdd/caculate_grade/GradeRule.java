package com.when.tdd.caculate_grade;

import java.time.LocalDate;

public class GradeRule {

	public String convertGradeNumberToNormalGradeName(Integer gradeNumber) {
		for (GradeName gradeName : GradeName.values()) {
			if (gradeName.getGradeNumber() == gradeNumber) {
				return gradeName.name();
			}
		}
		throw new IllegalArgumentException("Unsupported grade number");
	}

	public String convertDateToGradeName(LocalDate date) {
		return String.valueOf(date.getYear()) + "级";
	}

}
