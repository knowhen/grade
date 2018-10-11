package com.when.tdd.caculate_grade;

public enum GradeName {
	一年级(1), 二年级(2), 三年级(3), 四年级(4), 五年级(5), 六年级(6), 七年级(7), 八年级(8), 九年级(9), 高一(10), 高二(11), 高三(12);

	private int gradeNumber;

	private GradeName(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	public int getGradeNumber() {
		return gradeNumber;
	}

}
