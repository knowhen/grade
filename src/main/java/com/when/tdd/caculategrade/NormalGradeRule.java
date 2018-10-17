package com.when.tdd.caculategrade;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author when
 */
public class NormalGradeRule extends BaseGradeRule {

	@Override
	public int getGradeRule() {
		return 1;
	}

	@Override
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
