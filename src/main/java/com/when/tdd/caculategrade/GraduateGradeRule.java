package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class GraduateGradeRule extends BaseGradeRule {

	@Override
	public int getGradeRule() {
		return 3;
	}

	@Override
	public String getGradeName(LocalDate entranceDate, int gradeNumber, BaseGrade grade) {
		int graduateYear = grade.caculateGraduateYear(entranceDate, gradeNumber);
		return getGradeNameFromYear(graduateYear);
	}
}
