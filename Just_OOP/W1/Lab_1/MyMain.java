//import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class MyMain {
    public static void main() {
      long Stime = System.nanoTime();
    //Scanner ins = new Scanner(System.in);
      MyDate date1 = new MyDate(); 
      /*int daY,mouth,year;
      System.out.print("Day::");
      daY=ins.nextInt();
      System.out.print("Mouth::");
      mouth=ins.nextInt();
      System.out.print("Years::");
      year=ins.nextInt();*/
      date1.date_print();
      date1.setDay(8);date1.setMonth(1);date1.setYear(2021);
      date1.date_print();
      date1.setDay(29);date1.setMonth(9);date1.setYear(2021);
      date1.date_print();
      MyDate date2 = new MyDate(5,7,2025); 
      date2.date_print();
      long Etime = System.nanoTime();
      long DusTime = Etime - Stime;
      long DusLill = TimeUnit.NANOSECONDS.toMillis(DusTime);
      long DusSec = TimeUnit.NANOSECONDS.toSeconds(DusLill);
      System.out.println("::"+DusLill+"::");
    }
}
