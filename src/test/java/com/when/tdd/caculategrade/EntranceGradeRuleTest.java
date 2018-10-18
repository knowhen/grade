package com.when.tdd.caculategrade;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EntranceGradeRuleTest {
    private EntranceGradeRule entranceGradeRule = new EntranceGradeRule();
    private LocalDate date = LocalDate.now();
    private BaseGrade baseGrade;

    @Test
    public void testGetGradeRule() {
        assertSame(2, entranceGradeRule.getGradeRule());
    }

    @Test
    public void testGetGradeNameFromEntranceDate() {
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
        assertEquals("2018级", entranceGradeRule.getGradeName(LocalDate.of(2018, 9, 1), 1, baseGrade, date));
    }

    @Test
    public void testGetGradeNameFromEntranceDateWithMidwayStudent() {
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
        assertEquals("2016级", entranceGradeRule.getGradeName(LocalDate.of(2018, 9, 1), 3, baseGrade, date));
    }
}