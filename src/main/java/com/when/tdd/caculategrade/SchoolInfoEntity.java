package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class SchoolInfoEntity {
    private int schoolType;
    private int gradeRule;

    public SchoolInfoEntity(int schoolType, int gradeRule) {
        this.schoolType = schoolType;
        this.gradeRule = gradeRule;
    }

    public int getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(int schoolType) {
        this.schoolType = schoolType;
    }

    public int getGradeRule() {
        return gradeRule;
    }

    public void setGradeRule(int gradeRule) {
        this.gradeRule = gradeRule;
    }

}
