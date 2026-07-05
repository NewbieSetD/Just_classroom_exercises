import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
public class CH7_Ex6
{
	String InnexTLine() {
		Scanner ins = new Scanner(System.in);
		return ins.nextLine();
	}
	public static void main(String[] args) {
		CH7_Ex6 fun = new CH7_Ex6();
		for(;;){
		System.out.println("Input(1): ");
		String Input1 = fun.InnexTLine();
		System.out.println("Input(2): ");
		String Input2 = fun.InnexTLine();
		System.out.println("Input(3): ");
		String Input3 = fun.InnexTLine();
		String dayofyear = fun.getDayMofYearofHouse(Input1);
		String dayofmou = fun.getDayMofYearofHouse(Input2);
		String time = fun.getDayMofYearofHouse(Input3);
		fun.OutLine(dayofyear,dayofmou,time);
		}
	
	}
	void OutLine(String dayofyear,String dayofmou,String time ) {
		System.out.println(dayofyear);
		System.out.println(dayofmou);
		System.out.println(time);
	}
	String getDayMofYearofHouse(String Input) {
          Locale loc = new Locale("en");
	     SimpleDateFormat TeX = new SimpleDateFormat(Input,loc);
	     Date Det = new Date();
	     return TeX.format(Det);
	}/*
d : E : MMM : y
F : d : D
H : m : s
*/
}