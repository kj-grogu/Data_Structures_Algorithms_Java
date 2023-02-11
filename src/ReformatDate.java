import java.util.*;
// 1507. Reformat Date
//https://leetcode.com/problems/reformat-date/
// Given a date string in the form Day Month Year, where:

// Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
// Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
// Year is in the range [1900, 2100].
// Convert the date string to the format YYYY-MM-DD, where:

// YYYY denotes the 4 digit year.
// MM denotes the 2 digit month.
// DD denotes the 2 digit day.

public class ReformatDate {
	
		public static String reformatDate(String date) {
			String [] dateArr = date.split(" ");
			Map<String, Integer> months = new HashMap<String, Integer>()
			{{
				put("Jan",1); put("Feb",2); put( "Mar",3);
				put("Apr",4); put("May",5); put("Jun",6); 
				put("Jul",7); put("Aug",8); put("Sep",9); 
				put("Oct",10);put("Nov",11);put("Dec",12);
			}}; 
			//The trick here is the this regex: understand this. 
			String [] day = date.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
			System.out.println("day : " + Arrays.toString(day));
			String retdate = dateArr[2] + "-" + String.format("%02d", months.get(dateArr[1])) + "-" + String.format ("%02d",  Integer.parseInt( day[0]));
	
			return retdate;
		}
	public static void main(String [] args){
		String date = "20th Oct 2052";
		System.out.println(reformatDate(date));
	}
}
