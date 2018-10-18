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

	private BaseGrade grade;
	private BaseGradeRule gradeRule;

	public School(int schoolType, int gradeRule) {
		setGrade(schoolType);
		setGradeRule(gradeRule);
	}

	public void setGrade(int schoolType) {
		switch (schoolType) {
		case PRIMARY_SCHOOL:
			grade = new PrimarySchoolGrade();
			break;
		case MIDDLE_SCHOOL:
			grade = new MiddleSchoolGrade();
			break;
		case HIGH_SCHOOL:
			grade = new HighSchoolGrade();
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

	public BaseGrade getGrade() {
		return grade;
	}

	public String getGradeName(LocalDate entranceDate, int gradeNumber) {
		return gradeRule.getGradeName(entranceDate, gradeNumber, grade);
	}

}
