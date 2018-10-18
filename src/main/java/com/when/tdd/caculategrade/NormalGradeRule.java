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
	public String getGradeName(LocalDate entranceDate, int gradeNumber, BaseGrade grade) {
		int currentGradeNumber = grade.getCurrentGradeNumber(entranceDate, gradeNumber);
		return GradeName.getGradeNameFromNumber(currentGradeNumber);
	}

}
