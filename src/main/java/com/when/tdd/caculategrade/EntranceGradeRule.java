package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class EntranceGradeRule extends BaseGradeRule {

	@Override
	public int getGradeRule() {
		return 2;
	}

	@Override
	public String getGradeName(LocalDate entranceDate, int gradeNumber, BaseGrade grade) {
		int entranceYear = grade.caculateEntranceYear(entranceDate, gradeNumber);
		return getGradeNameFromYear(entranceYear);
	}
}
