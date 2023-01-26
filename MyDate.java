
/**
 * class MyDate 
 *
 * @author Nadezhda Rusina
 * @version Spring 2019
 */
public class MyDate
{
    // instance variables 
    private int day;
    private int month;
    private int year;  

    /**
     * Empty Constructor for objects of class MyDate
     */
    public MyDate() {
        this(1,1,2000);
    }

    /**
     * The Full Constructor for objects of class MyDate
     */
    public MyDate(int month, int day, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    /**
     * The Constructor accepts as a parameter MyDate object
     * This constructor is needed to use to compare two objects
     */        
    public MyDate(MyDate other) {
        this(other.month, other.day, other.year);
    } 

    /*  accessors*/
    /**
     * @return this.month an instance variable
     */
    public int getMonth() { return this.month; }

    /**
     * @return this.day an instance variable
     */
    public int getDay() { return this.day; } 

    /**
     * @return this.Year an instance variable
     */  
    public int getYear() {
        return this.year;
    }    

    /*  mutators*/   
    /**
     * Mutator - set a new day after precondition a given value
     * @param day the day of the date
     */  
    public void setDay(int day) {
        if(day < 0 || day > 31) {
            throw new IllegalArgumentException("The day should be from 1 to 31");
        }
        this.day = day;
    }

    /**
     * Mutator - set a new month after precondition a given value
     * @param month the month of the date
     */  
    public void setMonth(int month) {
        if(month < 0 || month > 12) {
            throw new IllegalArgumentException("The month should be from 1 to 12");
        }
        this.month = month;
    }    

    /**
     * Mutator - set a new year after precondition a given value
     * @param year the year of the date
     */  
    public void setYear(int year) {
        if(year < 0) {
            throw new IllegalArgumentException("The year should be >0");
        }
        this.year = year;
    }  

    /**
     * The method determines the number of days in the given month
     *
     * @return  days     the number of days in this.month  
     */
    public int getDaysInMonth() {
        int days = 31;
        if (month==4 || month==6 || month==9 || month==11) {
            days=30; 
        } else if (month==2) { 
            days = 28;
            if(isLeapYear()) days= 29;
        }
        return days;
    }     

    /**
     * Ths method determines if this.year is a leap year?
     * 
     * @return  boolean
     */
    public boolean isLeapYear() {
        return year%400==0 || (year%100!=0 && year%4==0); 
    }

    /**
     * The method determines the number of days in the given year
     * 
     * @return  days     the number of days in this.year  
     */
    public int getDaysInYear() {
        int days = 365;
        if (isLeapYear()) days = 366;
        return days;
    }

    /**
     * The method alculate the next day after a current date
     *  changing the current date
     */
    public void getNextDay() {
        day++;
        if (day > getDaysInMonth()) {
            // the next month
            month++;
            day = 1;
            if (month > 12) {
            // next year
                month = 1;
                year++;
            }
        }         
    }   
    
    /**
     * The method returns a new date after a given date
     *
     * @param  other   a given date
     * @return  other  the object that represents the date after the given date  
     */
    public MyDate getNextDay(MyDate other) {
        other.day++;
        if (other.day > getDaysInMonth()) {
            // the next month
            other.month++;
            other.day = 1;
            if (other.month > 12) {
            // next year
                other.month = 1;
                other.year++;
            }
        } 
        return other;
    }   
    
    /**
     * The method calculates the difference between two dates
     *
     * @param  other   a current date
     * @return  days   the number of days between two dates  
     */  
    public int daysBetween(MyDate other) {
        int days = 0;
        MyDate temp = new MyDate(this);
        // count the number of days
        // this method assumes if other date is after this date
        while(temp.day != other.day || temp.month != other.month || temp.year != other.year) {
            temp.getNextDay(temp);
            days++;
        }
        return days;
    }    
    
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
    
    /**
     * The example of testing method. There is not a full testing.
     * You need to test all constructors and all methods
     */
    public static void test() {
        // test the empty constructor
        MyDate testDate = new MyDate();
        if(testDate.getDay()!=1) System.out.println("Day must be equal 1 but the result is "+testDate.getDay());
        if(testDate.getMonth()!=1) System.out.println("Month must be equal 1 but the result is "+testDate.getMonth());
        if(testDate.getYear()!=2000) System.out.println("Year must be equal 2000 but the result is "+testDate.getYear());
        System.out.println(testDate);

        testDate.setDay(31);
        if(testDate.getDay()!=31) System.out.println("THe day must be = 31");
    }    
}
