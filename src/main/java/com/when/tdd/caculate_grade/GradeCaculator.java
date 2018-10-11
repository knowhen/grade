package com.when.tdd.caculate_grade;

import java.time.LocalDate;
import java.time.Period;

public class GradeCaculator {

	public String caculate(LocalDate entranceDate, int schoolType, int gradeRule, int gradeNumber) {
		checkEntranceDate(entranceDate);
		// 根据学校类型，入学时间，初始年级编号计算毕业时间
		LocalDate graduateDate = caculateGraduateDate(schoolType, entranceDate, gradeNumber);
		// 检查是否已经毕业
		checkGraduateDate(graduateDate);
		// 根据入学时间，毕业时间，初始年级编号和学校年级规则，返回当前学生年级名
		return getGradeName(entranceDate, graduateDate, gradeRule, gradeNumber);
	}

	private void checkEntranceDate(LocalDate entranceDate) {
		if (null == entranceDate) {
			throw new IllegalArgumentException("Student is out of school");
		}
	}

	private void checkGraduateDate(LocalDate graduateDate) {
		if (LocalDate.now().isAfter(graduateDate)) {
			throw new IllegalArgumentException("Student graduated from school");
		}
	}

	private LocalDate caculateGraduateDate(int schoolType, LocalDate entranceDate, int gradeNumber) {
		// 入学年份
		int yearOfEntrance = entranceDate.getYear();
		// 毕业的年份
		int yearsOfGraduate;
		switch (schoolType) {
		case 1:
			yearsOfGraduate = 7 - gradeNumber + yearOfEntrance;
			break;
		case 2:
			yearsOfGraduate = 11 - gradeNumber + yearOfEntrance;
			break;
		case 3:
			yearsOfGraduate = 13 - gradeNumber + yearOfEntrance;
			break;
		default:
			throw new IllegalArgumentException("Illegal school type");
		}
		return LocalDate.of(yearsOfGraduate, 9, 1);
	}

	private String getGradeName(LocalDate entranceDate, LocalDate graduateDate, int gradeRule, int gradeNumber) {
		switch (gradeRule) {
		case 1:
			int currentGradeNumber = getCurrentGradeNumber(entranceDate, gradeNumber);
			return getGradeNameFromNumber(currentGradeNumber);
		case 2:
			return getGradeNameFromDate(entranceDate);
		case 3:
			return getGradeNameFromDate(graduateDate);
		default:
			throw new IllegalArgumentException("Illegal school type");
		}
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

	private String getGradeNameFromDate(LocalDate date) {
		return String.valueOf(date.getYear()) + "级";
	}
}
