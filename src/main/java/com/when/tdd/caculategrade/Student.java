package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class Student {
    private int gradeNumber;
    private String gradeName;
    private School school;
    private LocalDate entranceDate;
    private LocalDate graduateDate;

    public Student(LocalDate entranceDate, int gradeNumber, School school) {
        this.entranceDate = entranceDate;
        this.gradeNumber = gradeNumber;
        this.school = school;
        setGraduateDate();
        setGradeName();
    }

    public LocalDate getEntranceDate() {
        return entranceDate;
    }

    public LocalDate getGraduateDate() {
        return graduateDate;
    }

    public int getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(int gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public void setEntranceDate(LocalDate entranceDate) {
        this.entranceDate = entranceDate;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setGraduateDate() {
        this.graduateDate = caculateGradeDate();
    }


    public void setGradeName() {
        this.gradeName = getGradeNameOfDate(LocalDate.now());
    }

    public String getGradeName() {
        return gradeName;
    }

    public String getGradeNameOfDate(LocalDate date) {
        return school.getGradeName(entranceDate, gradeNumber);
    }

    private LocalDate caculateGradeDate() {
        int graduateYear = school.getGrade().caculateGraduateYear(entranceDate, gradeNumber);
        return LocalDate.of(graduateYear, 9, 1);
    }
}
