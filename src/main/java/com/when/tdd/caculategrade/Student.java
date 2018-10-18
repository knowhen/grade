package com.when.tdd.caculategrade;

import java.time.LocalDate;

/**
 * @author when
 */
public class Student {
    private int gradeNumber;
    private LocalDate entranceDate;

    public Student(LocalDate entranceDate, int gradeNumber) {
        this.entranceDate = entranceDate;
        this.gradeNumber = gradeNumber;
    }

    public LocalDate getEntranceDate() {
        return entranceDate;
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

}
