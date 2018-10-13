package com.when.tdd.caculate_grade;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GradeCaculatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private GradeCaculator caculator = new GradeCaculator();

	private Student student;

	private School school;

	@Before
	public void setUp() {
		student = mock(Student.class);
		school = mock(School.class);
	}

	@Test
	public void whenStudentNotEnrolledThenThrowIllegalArgumentException() {
		when(student.getEntranceDate()).thenReturn(null);
		exception.expect(IllegalArgumentException.class);

		caculator.caculate(student, school);
	}

	@Test
	public void whenStudentGraduatedThenThrowIllegalArgumentException() {
		when(student.getEntranceDate()).thenReturn(LocalDate.of(2012, 9, 1));
		when(student.getGradeNumber()).thenReturn(1);
		when(school.getGradeRule()).thenReturn(1);
		when(school.getSchoolType()).thenReturn(1);
		exception.expect(IllegalArgumentException.class);

		caculator.caculate(student, school);
	}

	@Test
	public void whenStudentAtPrimarySchoolThenReturnGradeName() {
		when(student.getEntranceDate()).thenReturn(LocalDate.of(2015, 9, 10));
		when(student.getGradeNumber()).thenReturn(1);
		when(school.getGradeRule()).thenReturn(1);
		when(school.getSchoolType()).thenReturn(1);

		String gradeName = caculator.caculate(student, school);
		assertEquals("四年级", gradeName);
	}

	@Test
	public void whenStudentAtMiddleSchoolThenReturnGradeName() {
		when(student.getEntranceDate()).thenReturn(LocalDate.of(2017, 9, 1));
		when(student.getGradeNumber()).thenReturn(7);
		when(school.getGradeRule()).thenReturn(1);
		when(school.getSchoolType()).thenReturn(2);

		String gradeName = caculator.caculate(student, school);
		assertEquals("八年级", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeName() {
		when(student.getEntranceDate()).thenReturn(LocalDate.of(2016, 9, 1));
		when(student.getGradeNumber()).thenReturn(10);
		when(school.getGradeRule()).thenReturn(1);
		when(school.getSchoolType()).thenReturn(3);

		String gradeName = caculator.caculate(student, school);
		assertEquals("高三", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromEntranceDate() {
		when(student.getEntranceDate()).thenReturn(LocalDate.of(2016, 9, 1));
		when(student.getGradeNumber()).thenReturn(10);
		when(school.getGradeRule()).thenReturn(2);
		when(school.getSchoolType()).thenReturn(3);
		
		String gradeName = caculator.caculate(student, school);
		assertEquals("2016级", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromGraduateDate() {
		when(student.getEntranceDate()).thenReturn(LocalDate.of(2016, 9, 1));
		when(student.getGradeNumber()).thenReturn(10);
		when(school.getGradeRule()).thenReturn(3);
		when(school.getSchoolType()).thenReturn(3);

		String gradeName = caculator.caculate(student, school);
		assertEquals("2019级", gradeName);
	}

}
