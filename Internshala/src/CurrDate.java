
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class CurrDate {
    public static void main(String s[]) {

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
        LocalDate  localDate = LocalDate.now();
        System.out.println("Date: "+dtf1.format(localDate));
        DateTimeFormatter dtf2= DateTimeFormatter.ofPattern("HH:mm:ss ");
        LocalTime localTime = LocalTime.now();
        System.out.println("Time: "+dtf2.format(localTime));

    }

}
