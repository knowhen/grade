package com.when.tdd.caculate_grade;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GradeCaculatorTest {

	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private GradeCaculator caculator = new GradeCaculator();
	
	private Date dateOfEntrance;
	
	private Integer schoolType;
	
	private Integer gradeNumber;
	
	//private Date currentDate;
	
	@Test
	public void whenStudentNotEnrolledThenThrowIllegalArgumentException() {
		dateOfEntrance = null;
		//currentDate = new Date();
		schoolType = 1;
		gradeNumber = null;
		exception.expect(IllegalArgumentException.class);
		
		caculator.caculate(dateOfEntrance, schoolType, gradeNumber);
	}
	
	@Test
	public void whenStudentGraduateThenReturnGradeName() {
		dateOfEntrance = new Date(2015, 9, 10);
		schoolType = 1;
		gradeNumber = 1;
		
		String gradeName = caculator.caculate(dateOfEntrance, schoolType, gradeNumber);
		System.out.println(gradeName);
	}
	
	@Test
	public void whenStudentGraduateThenThrowIllegalArgumentException() {
		dateOfEntrance = new Date(2013, 9, 10);
		schoolType = 1;
		gradeNumber = 1;
		exception.expect(IllegalArgumentException.class);
		
		caculator.caculate(dateOfEntrance, schoolType, gradeNumber);
	}

}
