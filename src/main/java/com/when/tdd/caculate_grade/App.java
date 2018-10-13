package com.when.tdd.caculate_grade;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class App {
	public static void main(String[] args) {
		
		System.out.println(LocalDate.of(2018, 1, 1).getYear());
	}

	private static LocalDate dateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	enum GradeName {
		ONE(1, "一年级"), 
		TWO(2, "二年级"),
		THREE(3, "三年级"), 
		FOUR(4, "四年级"),
		FIVE(5, "五年级"), 
		SIX(6, "六年级"),
		SEVEN(7, "七年级"), 
		EIGHT(8, "八年级"),
		NINE(9, "九年级"), 
		TEN(10, "高一"),
		ELEVEN(11, "高二"), 
		TWELVE(12, "高三");

		int gradeNumber;
		String gardeName;

		GradeName(int gradeNumber, String gradeName) {
			this.gradeNumber = gradeNumber;
			this.gardeName = gradeName;
		}

		int getGradeNumber() {
			return gradeNumber;
		}
		
		String getGradeName() {
			return gardeName;
		}
	}
}
