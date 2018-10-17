package com.when.tdd.caculategrade;

/**
 * @author when
 */
public class GraduateGradeRule extends BaseGradeRule {

	@Override
	public int getGradeRule() {
		return 3;
	}

	@Override
	public String getGradeName(Student student) {
		return getGradeNameFromDate(student.getGraduateDate());
	}
}
