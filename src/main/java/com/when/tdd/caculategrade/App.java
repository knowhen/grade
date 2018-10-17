package com.when.tdd.caculategrade;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author when
 */
public class App {
	public static void main(String[] args) {

		System.out.println(LocalDate.of(2018, 1, 1).getYear());
		System.out.println(dateToLocalDate(new Date()));
	}

	private static LocalDate dateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
