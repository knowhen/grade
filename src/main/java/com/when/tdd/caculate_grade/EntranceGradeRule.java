package com.when.tdd.caculate_grade;

import java.time.LocalDate;

public class EntranceGradeRule extends GradeRule {
	

	@Override
	public int getGradeRule() {
		return 2;
	}

	/**
	 * 当学生中途入学时，根据正常入学年级，中途插入年级和入学时间计算实际年级名称
	 */
	@Override
	public String getGradeName(Student student) {
		int entranceGradeNumber = student.getSchool().getGradeNumber().getEntranceGradeNumber();
		int gradeNumber = student.getGradeNumber();
		int year = student.getEntranceDate().getYear() + entranceGradeNumber - gradeNumber;
		return getGradeNameFromDate(LocalDate.of(year, 9, 1));
	}
}
