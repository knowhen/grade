package com.when.tdd.caculategrade;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class NormalGradeRuleTest {
    private NormalGradeRule normalGradeRule = new NormalGradeRule();
    private BaseGrade baseGrade;

    @Test
    public void testGetGradeRule() {
        assertSame(1, normalGradeRule.getGradeRule());
    }

    @Test
    public void testGetGradeNameFromGradeNumber() {
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

        assertEquals("一年级", normalGradeRule.getGradeName(LocalDate.of(2018, 9, 1), 1, baseGrade));
    }

    @Test
    public void testGetGradeNameFromGradeNumberWithMidwayStudent() {
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

        assertEquals("三年级", normalGradeRule.getGradeName(LocalDate.of(2018, 9, 1), 3, baseGrade));
    }

}