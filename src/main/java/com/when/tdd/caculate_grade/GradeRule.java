package com.when.tdd.caculate_grade;

import java.time.LocalDate;

public abstract class GradeRule {

	public abstract int getGradeRule();

	public abstract String getGradeName(Student student);

	protected String getGradeNameFromDate(LocalDate date) {
		return String.valueOf(date.getYear()) + "级";
	}
}
