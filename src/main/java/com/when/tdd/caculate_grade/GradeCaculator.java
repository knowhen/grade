package com.when.tdd.caculate_grade;

import java.util.Date;

public class GradeCaculator {
	private String gradeName;
	private Date currentDate = new Date();
	private Date dateOfGraduate;
	private Integer currentGradeNumber;

	public String caculate(Date dateOfEntrance, Integer schoolType, Integer gradeNumber) {
		if (null == dateOfEntrance) {
			throw new IllegalArgumentException("Student is not enrolled");
		}
		
		dateOfGraduate = caculateGraduateDate(schoolType, gradeNumber, dateOfEntrance);
		//System.out.println(dateOfGraduate);
		
		if (currentDate.after(dateOfGraduate)) {
			throw new IllegalArgumentException("Student is graduated");
		}
		int currentYear = currentDate.getYear() + 1900;
		int entranceYear = dateOfEntrance.getYear();
		System.out.println("entranceYear:" + entranceYear);
		System.out.println("currentYear:" + currentYear);
		currentGradeNumber = gradeNumber + currentYear - entranceYear;
		// 根据currentGradeNumber和学校类型/规则为gradeName赋值
		return String.valueOf(currentGradeNumber);
		
	}

	private Date caculateGraduateDate(Integer schoolType, Integer gradeNumber, Date dateOfEntrance) {
		int yearsOfGraduate;
		int yearOfEntrance =  dateOfEntrance.getYear();
		switch (schoolType) {
			case 1:
				yearsOfGraduate = 6 - gradeNumber + yearOfEntrance - 1900;
				dateOfGraduate = new Date(yearsOfGraduate, 6, 10); 
				break;
			case 2:
				yearsOfGraduate = 3 - gradeNumber + yearOfEntrance - 1900;
				dateOfGraduate = new Date(yearsOfGraduate, 6, 10); 
				break;
			case 3:
				yearsOfGraduate = 3 - gradeNumber + yearOfEntrance - 1900;
				dateOfGraduate = new Date(yearsOfGraduate, 6, 10); 
				break;
			default:
				throw new IllegalArgumentException("Illegal school type");
		}
		return dateOfGraduate;
	}

}
