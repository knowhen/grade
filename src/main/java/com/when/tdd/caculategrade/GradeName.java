package com.when.tdd.caculategrade;

/**
 * 年级名称及其对应的年级编号
 * @author when
 */
public enum GradeName {
	/**
	 * 所有年级名称及对应编号
	 */
	一年级(1), 二年级(2), 三年级(3), 四年级(4), 五年级(5), 六年级(6), 七年级(7), 八年级(8), 九年级(9), 高一(10), 高二(11), 高三(12);

	/**
	 * 年级编号
	 */
	private int gradeNumber;

	private GradeName(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

	/**
	 * 获取年级编号
	 * 
	 * @return 年级编号
	 */
	public int getGradeNumber() {
		return gradeNumber;
	}
	
	public static String getGradeNameFromNumber(Integer gradeNumber) {
		for (GradeName gradeName : GradeName.values()) {
			if (gradeName.getGradeNumber() == gradeNumber) {
				return gradeName.name();
			}
		}
		throw new IllegalArgumentException("Unsupported grade number");
	}

}
