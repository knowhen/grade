package com.when.tdd.caculate_grade;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GradeRuleTest {

	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private GradeRule rule = new GradeRule();
	
	private Integer currentGradeNumber;
	
	private LocalDate date;
	
	@Test
	public void givenValidGradeNumberAndThenReturnNormalGradeName() {
		currentGradeNumber = 1;
		assertEquals("一年级", rule.convertGradeNumberToNormalGradeName(currentGradeNumber));
	}
	
	@Test
	public void givenAnotherValidGradeNumberAndThenReturnNormalGradeName() {
		currentGradeNumber = 10;
		assertEquals("高一", rule.convertGradeNumberToNormalGradeName(currentGradeNumber));
	}
	
	@Test
	public void givenValidGradeNumberAndThenReturnGradeNameFromDate() {
		date = LocalDate.of(2015, 9, 1);
		assertEquals("2015级", rule.convertDateToGradeName(date));
	}
	
	@Test
	public void givenInValidGradeNumberAndThenThrowIllegalArgumentException() {
		currentGradeNumber = 13;
		exception.expect(IllegalArgumentException.class);
		
		rule.convertGradeNumberToNormalGradeName(currentGradeNumber);
	}
	
}
