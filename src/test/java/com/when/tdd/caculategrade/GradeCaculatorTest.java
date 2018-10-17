package com.when.tdd.caculategrade;

import static org.junit.Assert.*;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.when.tdd.caculategrade.GradeCaculator;
import com.when.tdd.caculategrade.School;
import com.when.tdd.caculategrade.Student;
/**
 * 
 * @author when
 *
 */
public class GradeCaculatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private GradeCaculator caculator;

	private Student student;

	private School school;
	
	private LocalDate now;

	@Before
	public void setUp() {
		caculator = new GradeCaculator();
		now = LocalDate.now();
	}

	@Test
	public void whenStudentNotEnrolledThenThrowIllegalArgumentException() {
		school = new School(1, 1);
		student = new Student(now, 1, school);
		exception.expect(IllegalArgumentException.class);

		caculator.caculate(student, LocalDate.of(2017, 1, 1));
	}

	@Test
	public void whenStudentGraduatedThenThrowIllegalArgumentException() {
		school = new School(1, 1);
		student = new Student(LocalDate.of(2012, 9, 1), 1, school);
		exception.expect(IllegalArgumentException.class);

		caculator.caculate(student, now);
	}

	@Test
	public void whenStudentAtPrimarySchoolThenReturnGradeName() {
		school = new School(1, 1);
		student = new Student(LocalDate.of(2015, 9, 10), 1, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("四年级", gradeName);
	}

	@Test
	public void whenStudentAtMiddleSchoolThenReturnGradeName() {
		school = new School(2, 1);
		student = new Student(LocalDate.of(2017, 9, 1), 7, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("八年级", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeName() {
		school = new School(3, 1);
		student = new Student(LocalDate.of(2016, 9, 1), 10, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("高三", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromEntranceDate() {
		school = new School(3, 2);
		student = new Student(LocalDate.of(2016, 9, 1), 10, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("2016级", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromGraduateDate() {
		school = new School(3, 3);
		student = new Student(LocalDate.of(2016, 9, 1), 10, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("2019级", gradeName);
	}
	
	@Test
	public void givenMidwayEntranceStudentThenReturnGradeName() {
		school = new School(3, 1);
		student = new Student(LocalDate.of(2018, 9, 1), 11, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("高二", gradeName);
	}
	
	@Test
	public void givenMidwayEntranceStudentThenReturnGradeNameFromEntranceDate() {
		school = new School(3, 2);
		student = new Student(LocalDate.of(2018, 9, 1), 11, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("2017级", gradeName);
	}
	
	@Test
	public void givenMidwayEntranceStudentThenReturnGradeNameFormGraduateDate() {
		school = new School(3, 3);
		student = new Student(LocalDate.of(2018, 9, 1), 11, school);

		String gradeName = caculator.caculate(student, now);
		assertEquals("2020级", gradeName);
	}

}
