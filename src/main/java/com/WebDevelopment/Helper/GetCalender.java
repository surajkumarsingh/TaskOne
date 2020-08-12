package com.WebDevelopment.Helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class GetCalender {

	public String getJourneyDate() {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_YEAR, 2);
		String journeyDate = new SimpleDateFormat("EEE MMM dd yyyy").format(calendar.getTime());
		System.out.println(journeyDate);
		return journeyDate;

	}

	public String getreturningDate() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 5);
		String returningDate = new SimpleDateFormat("EEE MMM dd yyyy").format(calendar.getTime());
		System.out.println(returningDate);
		return returningDate;

	}
}
