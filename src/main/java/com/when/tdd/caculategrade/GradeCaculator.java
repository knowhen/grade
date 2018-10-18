package com.when.tdd.caculategrade;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author when
 */
public class GradeCaculator {
    private GradeData gradeData;

    public String getCurrentGradeName(StudentInfoEntity studentInfoEntity, SchoolInfoEntity schoolInfoEntity) {
        return getGradeNameOfDate(studentInfoEntity, schoolInfoEntity, LocalDate.now());
    }

    public String getGradeNameOfDate(StudentInfoEntity studentInfoEntity, SchoolInfoEntity schoolInfoEntity, LocalDate date) {
        initGradeDate(studentInfoEntity, schoolInfoEntity);
        return gradeData.getGradeNameOfDate(date);
    }

    private void initGradeDate(StudentInfoEntity studentInfoEntity, SchoolInfoEntity schoolInfoEntity) {
        LocalDate entranceDate = date2LocalDate(studentInfoEntity.getEntranceDate());
        int initialGradeNumber = studentInfoEntity.getGradeNumber();
        int schoolType = schoolInfoEntity.getSchoolType();
        int gradeRule = schoolInfoEntity.getGradeRule();
        gradeData = new GradeData(initialGradeNumber, entranceDate, schoolType, gradeRule);
    }

    private LocalDate date2LocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
