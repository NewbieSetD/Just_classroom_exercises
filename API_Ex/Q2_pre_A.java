import java.util.Scanner;
public class Q2_pre_A
{
     String scInline(){
          Scanner ins = new Scanner(System.in);
          return ins.nextLine();
     }
	public static void main(String[] args) {
	     Q2_pre_A fun = new Q2_pre_A();
		System.out.print("Input: ");
		String strIn  = fun.scInline();
		char []allchrt = strIn.toCharArray();
		short sum = fun.sumInarray(allchrt);
		System.out.println(sum);
	}
	short sumInarray(char[] nonsum){
	     short sum=0;
	     for (byte i=0;i<nonsum.length ;i++ ){
	         if(Character.isDigit(nonsum[i])){
	              sum+=	Character.digit(nonsum[i],nonsum.length);
	         } 
	     } 
	     return sum;
	}
}//Sdfd5g1gf321