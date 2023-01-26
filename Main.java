import java.util.Date;

/**
 * class Main for testing CSC142Date class
 *
 * @author Nadezhda Rusina
 * @version Spring 2019
 */
public class Main
{
    public static void main(String[] args) {
        // You can add statements for printing results of all methods in the class MyDate       
        MyDate d1 = new MyDate(4,29,2019);
        // d1.day = 17; This is not possible because a variable is private
        System.out.println(d1);
        
        // create an object using default parameters
        MyDate d2 = new MyDate();
        System.out.println(d2);
        
        // get information about the day and month from the object d1
        System.out.println("The date is " + d1.getDay() + "/" + d1.getMonth());
        
        // the next day after the current day
        d1.getNextDay();
        System.out.println("Tomorrow will be " + d1);
        
        // create one more instance of a cla MyDate
        MyDate dFinal = new MyDate(6,14,2019);
        System.out.println("The Final Exam will be after " + d1.daysBetween(dFinal) + " days");
        
        // example of using a class Date
        Date now = new Date();
        System.out.println("Today is: "+now);
    }
}
