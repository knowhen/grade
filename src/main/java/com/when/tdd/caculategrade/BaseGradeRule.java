package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public abstract class BaseGradeRule {

	/**
	 * 获取年级规则编号
	 * @return 学校年级制定规则编号
	 */
	public abstract int getGradeRule();

	/**
	 * 根据学生信息和该校年级制定规则获取学生年级名称
	 * 
	 * @param student
	 *            学生
	 * @return 学生当前年级名称
	 */
	public abstract String getGradeName(Student student);

	protected String getGradeNameFromDate(LocalDate date) {
		return String.valueOf(date.getYear()) + "级";
	}
}
