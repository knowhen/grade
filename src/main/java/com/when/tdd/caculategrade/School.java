package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class School {
	public static final int PRIMARY_SCHOOL = 1;
	public static final int MIDDLE_SCHOOL = 2;
	public static final int HIGH_SCHOOL = 3;

	public static final int NORMAL = 1;
	public static final int ENTRANCE_DATE = 2;
	public static final int GRADUATE_DATE = 3;

	private BaseGradeNumber gradeNumber;
	private BaseGradeRule gradeRule;

	public School() {
	}

	public School(int schoolType, int gradeRule) {
		setGraduateGradeNumber(schoolType);
		setGradeRule(gradeRule);
	}

	public void setGraduateGradeNumber(int schoolType) {
		switch (schoolType) {
		case PRIMARY_SCHOOL:
			gradeNumber = new PrimaryGradeNumber();
			break;
		case MIDDLE_SCHOOL:
			gradeNumber = new MiddleGradeNumber();
			break;
		case HIGH_SCHOOL:
			gradeNumber = new HighGradeNumber();
			break;
		default:
			throw new IllegalArgumentException("Incorrect school type");
		}
	}

	public void setGradeRule(int rule) {
		switch (rule) {
		case NORMAL:
			gradeRule = new NormalGradeRule();
			break;
		case ENTRANCE_DATE:
			gradeRule = new EntranceGradeRule();
			break;
		case GRADUATE_DATE:
			gradeRule = new GraduateGradeRule();
			break;
		default:
			throw new IllegalArgumentException("Incorrect grade rule");
		}
	}

	public int getGradeRule() {
		return gradeRule.getGradeRule();
	}

	public BaseGradeNumber getGradeNumber() {
		return gradeNumber;
	}

	public LocalDate caculateGraduateDate(Student student) {
		return gradeNumber.caculateGraduateDate(student);
	}

	public String getGradeName(Student student) {
		return gradeRule.getGradeName(student);
	}

}
