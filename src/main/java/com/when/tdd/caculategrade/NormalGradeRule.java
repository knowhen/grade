package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class NormalGradeRule extends BaseGradeRule {

	@Override
	public int getGradeRule() {
		return 1;
	}

	@Override
	public String getGradeName(LocalDate entranceDate, int gradeNumber, BaseGrade grade, LocalDate date) {
		int currentGradeNumber = grade.getCurrentGradeNumber(entranceDate, gradeNumber, date);
		return GradeName.getGradeNameFromNumber(currentGradeNumber);
	}

}
