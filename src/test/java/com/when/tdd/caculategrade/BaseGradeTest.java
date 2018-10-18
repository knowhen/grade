package com.when.tdd.caculategrade;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BaseGradeTest {
    private BaseGrade baseGrade = new PrimarySchoolGrade();
    private LocalDate date = LocalDate.now();

    @Test
    public void testGetCurrentGradeNumber() {
        int currentGradeNumber = baseGrade.getCurrentGradeNumber(LocalDate.of(2015, 9,1 ), 1, date);
        assertEquals(4, currentGradeNumber);
    }

    @Test
    public void testCaculateGraduateYear() {
        int year = baseGrade.caculateGraduateYear(LocalDate.of(2015, 9,1 ), 1);
        assertEquals(2021, year);
    }

    @Test
    public void testCaculateEntranceYear() {
        int year = baseGrade.caculateEntranceYear(LocalDate.of(2015, 9, 1), 3);
        assertEquals(2013, year);
    }
}