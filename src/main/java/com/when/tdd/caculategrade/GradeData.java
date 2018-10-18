package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author: when
 * @create: 2018-10-18  15:03
 **/
public class GradeData {
    public static final int PRIMARY_SCHOOL = 1;
    public static final int MIDDLE_SCHOOL = 2;
    public static final int HIGH_SCHOOL = 3;

    public static final int NORMAL = 1;
    public static final int ENTRANCE_DATE = 2;
    public static final int GRADUATE_DATE = 3;

    private int initialGradeNumber;
    private LocalDate entranceDate;
    private BaseGrade grade;
    private BaseGradeRule gradeRule;

    public GradeData(int initialGradeNumber, LocalDate entranceDate, int schoolType, int gradeRule) {
        this.initialGradeNumber = initialGradeNumber;
        this.entranceDate = entranceDate;
        setGrade(schoolType);
        setGradeRule(gradeRule);
    }

    public void setGrade(int schoolType) {
        switch (schoolType) {
            case PRIMARY_SCHOOL:
                grade = new PrimarySchoolGrade();
                break;
            case MIDDLE_SCHOOL:
                grade = new MiddleSchoolGrade();
                break;
            case HIGH_SCHOOL:
                grade = new HighSchoolGrade();
                break;
            default:
                throw new IllegalArgumentException("Incorrect school type");
        }
    }

    public void setGradeRule(int rule) {
        switch (rule) {
            case NORMAL:
                gradeRule = new NormalGradeRule();
                break;
            case ENTRANCE_DATE:
                gradeRule = new EntranceGradeRule();
                break;
            case GRADUATE_DATE:
                gradeRule = new GraduateGradeRule();
                break;
            default:
                throw new IllegalArgumentException("Incorrect grade rule");
        }
    }

    public String getGradeNameOfDate(LocalDate date) {
        checkEntranceDate(entranceDate, date);
        checkGraduateDate(caculateGraduateGradeDate(), date);
        return gradeRule.getGradeName(entranceDate, initialGradeNumber, grade, date);
    }

    public LocalDate caculateGraduateGradeDate() {
        int graduateYear = grade.caculateGraduateYear(entranceDate, initialGradeNumber);
        return LocalDate.of(graduateYear, 9, 1);
    }

    private void checkEntranceDate(LocalDate entranceDate, LocalDate date) {
        if (date.isBefore(entranceDate)) {
            throw new IllegalArgumentException("Student is not enrolled");
        }
    }

    private void checkGraduateDate(LocalDate graduateDate, LocalDate date) {
        if (date.isAfter(graduateDate)) {
            throw new IllegalArgumentException("Student graduated from school");
        }
    }

}
