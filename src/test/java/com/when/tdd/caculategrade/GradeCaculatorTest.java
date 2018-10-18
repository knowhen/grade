package com.when.tdd.caculategrade;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * @author when
 *
 */
public class GradeCaculatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private GradeCaculator caculator;

	private StudentInfoEntity studentInfoEntity;

	private SchoolInfoEntity schoolInfoEntity;
	
	private LocalDate now;

	private Date entranceDate;

	@Before
	public void setUp() {
		caculator = new GradeCaculator();
		now = LocalDate.now();
	}

	@Test
	public void whenStudentNotEnrolledThenThrowIllegalArgumentException() {
		schoolInfoEntity = new SchoolInfoEntity(1, 1);
		studentInfoEntity = new StudentInfoEntity(new Date(), 1);
		exception.expect(IllegalArgumentException.class);

		caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, LocalDate.of(2017, 1, 1));
	}

	@Test
	public void whenStudentGraduatedThenThrowIllegalArgumentException() {
		schoolInfoEntity = new SchoolInfoEntity(1, 1);
		Date entranceDate = localDate2Date(LocalDate.of(2012, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 1);
		exception.expect(IllegalArgumentException.class);

		caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, LocalDate.now());
	}

	@Test
	public void whenStudentAtPrimarySchoolThenReturnGradeName() {
		schoolInfoEntity = new SchoolInfoEntity(1, 1);
		entranceDate = localDate2Date(LocalDate.of(2015, 9, 10));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 1);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, LocalDate.now());
		assertEquals("四年级", gradeName);
	}

	@Test
	public void whenStudentAtMiddleSchoolThenReturnGradeName() {
		schoolInfoEntity = new SchoolInfoEntity(2, 1);
		entranceDate = localDate2Date(LocalDate.of(2017, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 7);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, LocalDate.now());
		assertEquals("八年级", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeName() {
		schoolInfoEntity = new SchoolInfoEntity(3, 1);
		entranceDate = localDate2Date(LocalDate.of(2016, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 10);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, LocalDate.now());
		assertEquals("高三", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromEntranceDate() {
		schoolInfoEntity = new SchoolInfoEntity(3, 2);
		entranceDate = localDate2Date(LocalDate.of(2016, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 10);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, LocalDate.now());
		assertEquals("2016级", gradeName);
	}

	@Test
	public void whenStudentAtHighSchoolThenReturnGradeNameFromGraduateDate() {
		schoolInfoEntity = new SchoolInfoEntity(3, 3);
		entranceDate = localDate2Date(LocalDate.of(2016, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 10);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, now);
		assertEquals("2019级", gradeName);
	}
	
	@Test
	public void givenMidwayEntranceStudentThenReturnGradeName() {
		schoolInfoEntity = new SchoolInfoEntity(3, 1);
		entranceDate = localDate2Date(LocalDate.of(2018, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 11);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, now);
		assertEquals("高二", gradeName);
	}
	
	@Test
	public void givenMidwayEntranceStudentThenReturnGradeNameFromEntranceDate() {
		schoolInfoEntity = new SchoolInfoEntity(3, 2);
		entranceDate = localDate2Date(LocalDate.of(2018, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 11);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, now);
		assertEquals("2017级", gradeName);
	}
	
	@Test
	public void givenMidwayEntranceStudentThenReturnGradeNameFormGraduateDate() {
		schoolInfoEntity = new SchoolInfoEntity(3, 3);
		entranceDate = localDate2Date(LocalDate.of(2018, 9, 1));
		studentInfoEntity = new StudentInfoEntity(entranceDate, 11);

		String gradeName = caculator.getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, now);
		assertEquals("2020级", gradeName);
	}

	private LocalDate date2LocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private Date localDate2Date(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
