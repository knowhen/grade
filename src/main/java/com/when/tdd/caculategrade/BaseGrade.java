package com.when.tdd.caculategrade;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author when
 */
public abstract class BaseGrade {
	/**
	 * 获取本校毕业年级编号 + 1
	 * 
	 * @return 毕业年级编号 + 1
	 */
	abstract int getGraduateGradeNumber();

	/**
	 * 获取本校入学时初始年级编号
	 * 
	 * @return 初始入学年级编号
	 */
	abstract int getEntranceGradeNumber();

	public int getCurrentGradeNumber(LocalDate entranceDate, int gradeNumber) {
		LocalDate currentDate = LocalDate.now();
		Period period = entranceDate.until(currentDate);
		return gradeNumber + period.getYears();
	}

	public int caculateGraduateYear(LocalDate entranceDate, int gradeNumber) {
		return entranceDate.getYear() + getGraduateGradeNumber() - gradeNumber;
	}

	public int caculateEntranceYear(LocalDate entranceDate, int gradeNumber) {
		return entranceDate.getYear() + getEntranceGradeNumber() - gradeNumber;
	}

}
