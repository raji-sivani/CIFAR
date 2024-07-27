package com.adbms.data;

import java.util.ArrayList;
import java.util.List;

public class DayToDate {
	
	//Returns a String of all dates corresponding to particular day
	public static String getDateFromDay(String day){
		List<String> dates = new ArrayList<String>();
		
		if(day.equalsIgnoreCase("Thursday")) {
			dates.add("2017-06-01");
			dates.add("2017-06-08");
			dates.add("2017-06-15");
			dates.add("2017-06-22");
		}
		else if(day.equalsIgnoreCase("Friday")) {
			dates.add("2017-06-02");
			dates.add("2017-06-09");
			dates.add("2017-06-16");
			dates.add("2017-06-23");
		}
		else if(day.equalsIgnoreCase("Saturday")) {
			dates.add("2017-06-03");
			dates.add("2017-06-10");
			dates.add("2017-06-17");
			dates.add("2017-06-24");
		}
		else if(day.equalsIgnoreCase("Sunday")) {
			dates.add("2017-06-04");
			dates.add("2017-06-11");
			dates.add("2017-06-18");
			dates.add("2017-06-25");
		}
		else if(day.equalsIgnoreCase("Monday")) {
			dates.add("2017-06-05");
			dates.add("2017-06-12");
			dates.add("2017-06-19");
			dates.add("2017-06-26");
		}
		else if(day.equalsIgnoreCase("Tuesday")) {
			dates.add("2017-06-06");
			dates.add("2017-06-13");
			dates.add("2017-06-20");
			dates.add("2017-06-27");
		}	
		else if(day.equalsIgnoreCase("Wednesday")) {
			dates.add("2017-06-07");
			dates.add("2017-06-14");
			dates.add("2017-06-21");
			dates.add("2017-06-28");
		}
		
		
		String allDates = "";
		for (int i = 0; i < dates.size() - 1; i++) {
			allDates = allDates + "'" + dates.get(i) + "'" + ",";
	    }  
		allDates = allDates + "'" + dates.get(dates.size()-1) + "'";
		//System.out.println(allDates);
		
		return allDates;
	}

}
