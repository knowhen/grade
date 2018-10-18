package com.when.tdd.caculategrade;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BaseGradeRuleTest {
    private BaseGradeRule gradeRule = new BaseGradeRule() {
        @Override
        public int getGradeRule() {
            return 0;
        }

        @Override
        public String getGradeName(LocalDate entranceDate, int gradeNumber, BaseGrade grade) {
            return null;
        }
    };

    @Test
    public void testGetGradeNameFromYear() {
        assertEquals("2015级", gradeRule.getGradeNameFromYear(2015));
    }
}