package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public abstract class BaseGradeNumber {
	/**
	 * 获取本校毕业年级编号 + 1
	 * @return 毕业年级编号 + 1
	 */
	abstract int getGraduateGradeNumber();

	/**
	 * 获取本校入学时初始年级编号
	 * @return 初始入学年级编号
	 */
	abstract int getEntranceGradeNumber();

	public LocalDate caculateGraduateDate(Student student) {
		int yearsToGraduate = getGraduateGradeNumber() - student.getGradeNumber();
		int year = student.getEntranceDate().getYear() + yearsToGraduate;
		return LocalDate.of(year, 9, 1);
	}

}
