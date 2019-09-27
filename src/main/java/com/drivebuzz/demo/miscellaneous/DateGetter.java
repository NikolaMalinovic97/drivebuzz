package com.drivebuzz.demo.miscellaneous;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateGetter {

	public String getTodaysDate() {
		
		long millis = System.currentTimeMillis();
		Date sqlTodaysDate = new Date(millis);
		
		String todaysDate = sqlTodaysDate.toString();
		
		return todaysDate;
	}
	
	public String getSevenDaysFromNowDate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 6);
		String seventhDayDate = sdf.format(calendar.getTime());
		
		return seventhDayDate;
	}
	
	public String getMonthFromNowDate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		String lastDayDate = sdf.format(calendar.getTime());
		
		return lastDayDate;
	}
}
