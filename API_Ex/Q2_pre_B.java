import java.util.Arrays;
import java.util.Scanner;
public class Q2_pre_B
{
     String scInline(){
          Scanner ins = new Scanner(System.in);
          return ins.nextLine();
     }
	public static void main(String[] args) {
	     Q2_pre_B fun = new Q2_pre_B();
		System.out.print("Input: ");
		String strIn  = fun.scInline();
		//System.out.println(strIn.length());
		System.out.println(fun.getTranUpper(strIn));
		
	}
	String getTranUpper(String inpu){
	     int idexstr = inpu.length();
	     char []pio = inpu.toCharArray();
	     if(idexstr%2==0){
	         idexstr--; 
	     }
	     makeitUpper(pio,idexstr);
	     String Tranchar = String.copyValueOf(pio);
	     return Tranchar;
	}
	void makeitUpper(char[] mun,int ide){
	     char[]pp = Arrays.copyOf(mun,mun.length);
	     for(byte i=0;i<mun.length;i++){
	     if(ide%2==1){
	          mun[i] = 	Character.toUpperCase(pp[i]);
	     }
	     else{
	          mun[i] = Character.	toLowerCase(pp[i]);
	     }
	     ide--;
	     }
	}
}//interface
//Document