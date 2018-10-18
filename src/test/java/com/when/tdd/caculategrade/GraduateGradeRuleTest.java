package com.when.tdd.caculategrade;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class GraduateGradeRuleTest {
    private GraduateGradeRule graduateGradeRule = new GraduateGradeRule();
    private BaseGrade baseGrade;

    @Test
    public void testGetGradeRule() {
        assertSame(3, graduateGradeRule.getGradeRule());
    }

    @Test
    public void testGetGradeNameFromGraduateDate() {
        baseGrade = new BaseGrade() {
            @Override
            int getGraduateGradeNumber() {
                return 7;
            }

            @Override
            int getEntranceGradeNumber() {
                return 1;
            }
        };
        assertEquals("2024级", graduateGradeRule.getGradeName(LocalDate.of(2018, 9, 1), 1, baseGrade));
    }

    @Test
    public void testGetGradeNameFromGraduateDateWithMidwayStudent() {
        baseGrade = new BaseGrade() {
            @Override
            int getGraduateGradeNumber() {
                return 7;
            }

            @Override
            int getEntranceGradeNumber() {
                return 1;
            }
        };
        assertEquals("2022级", graduateGradeRule.getGradeName(LocalDate.of(2018, 9, 1), 3, baseGrade));
    }
}