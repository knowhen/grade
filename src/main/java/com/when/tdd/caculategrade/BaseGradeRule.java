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
	 * 根据学生入学时间、入学年级编号和学校年级信息获取学生年级名称
	 * @param entranceDate 入学时间
	 * @param gradeNumber 入学年级编号
	 * @param grade 学校年级信息
	 * @return 学生年级名称
	 */
	public abstract String getGradeName(LocalDate entranceDate, int gradeNumber, BaseGrade grade);

	protected String getGradeNameFromYear(int year) {
		return String.valueOf(year) + "级";
	}
}
