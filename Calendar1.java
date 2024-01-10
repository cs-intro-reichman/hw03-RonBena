/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	public static void main(String args[]) {
		int debugDaysCounter = 0;
		int sundaysCount = 0;
	 	while (year < 2000) {
			System.out.print(dayOfMonth + "/" + month + "/" + year);
			if(dayOfWeek == 1) {
				System.out.print(" sunday");
				if(dayOfMonth == 1) {
					sundaysCount++;
				}
			}
			System.out.println("");
			advance();
			debugDaysCounter++;
			if (debugDaysCounter == 36500) {
				break;
			}
		}
		System.out.print("During the 20th century, " + sundaysCount + " Sundays fell on the first day of the month");
	}
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		dayOfWeek++;
		if(dayOfWeek > 7) {
			dayOfWeek = 1;
		}
		dayOfMonth++;
		if(dayOfMonth > nDaysInMonth) {
			month++;
			dayOfMonth = 1;
			if(month > 12) {
				year++;
				month = 1;
			}
		}
		nDaysInMonth = nDaysInMonth(month, year);
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean isLeapYear=false;
			// Checks if the year is divisible by 400
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
	private static int nDaysInMonth(int month, int year) {
		int daysinmonth;
			switch (year) {
			case 4,6,9,11: daysinmonth = 30 ;
			break;
			case 2: if(isLeapYear(year)) daysinmonth = 28 ; else daysinmonth = 29;
			break;
			default: daysinmonth = 31;
			break;
			}
			return daysinmonth;
	}
	
}
