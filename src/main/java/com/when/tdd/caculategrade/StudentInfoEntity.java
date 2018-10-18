package com.when.tdd.caculategrade;

import java.util.Date;

/**
 * @author when
 */
public class StudentInfoEntity {
    private int gradeNumber;
    private Date entranceDate;

    public StudentInfoEntity(Date entranceDate, int gradeNumber) {
        this.entranceDate = entranceDate;
        this.gradeNumber = gradeNumber;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public int getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(int gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

}
