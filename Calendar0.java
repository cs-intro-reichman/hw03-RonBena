/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[]) {
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}
		 
	// Tests the isLeapYear function.
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	// Tests the nDaysInMonth function.
	private static void nDaysInMonthTest(int year) {
		for(int i = 1; i < 13; i++) {
			System.out.println("Month " + i + " has " + nDaysInMonth(i, year) + " days");
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		if((year % 400) == 0) {
			isLeapYear = true;
		} else if(((year % 4) == 0) && ((year % 100) != 0)) {
			isLeapYear = true;
		}
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) {
			int daysinmonth;
			switch (month) {
			case 4,6,9,11: daysinmonth = 30 ;
			break;
			case 2: if(isLeapYear(year)) daysinmonth = 29 ; else daysinmonth = 28;
			break;
			default: daysinmonth = 31;
			break;
			}
			return daysinmonth;
	}
}

