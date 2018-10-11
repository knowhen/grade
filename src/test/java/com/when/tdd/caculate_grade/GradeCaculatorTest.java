package com.when.tdd.caculate_grade;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GradeCaculatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private GradeCaculator caculator = new GradeCaculator();

	private LocalDate entranceDate;

	private int schoolType;

	private int gradeNumber;

	private int gradeRule;

	@Test
	public void whenStudentNotEnrolledThenThrowIllegalArgumentException() {
		entranceDate = null;
		schoolType = 1;
		gradeRule = 1;
		exception.expect(IllegalArgumentException.class);

		caculator.caculate(entranceDate, schoolType, gradeRule, gradeNumber);
	}
	
	@Test
	public void whenStudentGraduatedThenThrowIllegalArgumentException() {
		entranceDate = LocalDate.of(2012, 9, 1);
		schoolType = 1;
		gradeNumber = 1;
		gradeRule = 1;
		exception.expect(IllegalArgumentException.class);

		caculator.caculate(entranceDate, schoolType, gradeRule, gradeNumber);
	}

	@Test
	public void whenStudentAtPrimarySchoolThenReturnGradeName() {
		entranceDate = LocalDate.of(2015, 9, 10);
		schoolType = 1;
		gradeNumber = 1;
		gradeRule = 1;

		String gradeName = caculator.caculate(entranceDate, schoolType, gradeRule, gradeNumber);
		assertEquals("四年级", gradeName);
	}

	@Test
	public void whenStudentAtMiddleSchoolThenReturnGradeName() {
		entranceDate = LocalDate.of(2017, 9, 1);
		schoolType = 2;
		gradeNumber = 7;
		gradeRule = 1;

		String gradeName = caculator.caculate(entranceDate, schoolType, gradeRule, gradeNumber);
		assertEquals("八年级", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeName() {
		entranceDate = LocalDate.of(2016, 9, 1);
		schoolType = 3;
		gradeNumber = 10;
		gradeRule = 1;

		String gradeName = caculator.caculate(entranceDate, schoolType, gradeRule, gradeNumber);
		assertEquals("高三", gradeName);
	}
	
	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromEntranceDate() {
		entranceDate = LocalDate.of(2016, 9, 1);
		schoolType = 3;
		gradeNumber = 10;
		gradeRule = 2;

		String gradeName = caculator.caculate(entranceDate, schoolType, gradeRule, gradeNumber);
		assertEquals("2016级", gradeName);
	}
	
	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromGraduateDate() {
		entranceDate = LocalDate.of(2016, 9, 1);
		schoolType = 3;
		gradeNumber = 10;
		gradeRule = 3;

		String gradeName = caculator.caculate(entranceDate, schoolType, gradeRule, gradeNumber);
		assertEquals("2019级", gradeName);
	}

}
