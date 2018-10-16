package com.when.tdd.caculate_grade;

public class GraduateGradeRule extends GradeRule {

	@Override
	public int getGradeRule() {
		return 3;
	}

	@Override
	public String getGradeName(Student student) {
		return getGradeNameFromDate(student.getGraduateDate());
	}
}
