public class Calendar {
    static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;
	static int nDaysInMonth = 31;
	
	public static void main(String args[]) {
		int givenYear = Integer.parseInt(args[0]);
        while (year < givenYear) {
          advance();
        } 
        while (year == givenYear) {
          System.out.print(dayOfMonth + "/" + month + "/" + year);
          if(dayOfWeek == 1) {
            System.out.print(" Sunday");
          }
            advance();
            System.out.println("");
        }
        }
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
    public static boolean isLeapYear(int year) {
      boolean isLeapYear = false;
      if((year % 400) == 0) {
        isLeapYear = true;
      } else if(((year % 4) == 0) && ((year % 100) != 0)) {
        isLeapYear = true;
      }
      return isLeapYear;
      }
       
      private static int nDaysInMonth(int month, int year) {
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

