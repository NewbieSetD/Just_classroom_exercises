import java.util.Scanner;
public class CH7_Ex2
{
     String scInline(){
          Scanner ins = new Scanner(System.in);
          return ins.nextLine();
     }
	public static void main(String[] args) {
	     CH7_Ex2 fun = new CH7_Ex2();
		System.out.print("Input: ");
		String strIn  = fun.scInline();
		//int x = strIn.length()/2;
		//System.out.println(x);
		fun.outline(strIn);
	}
	void outline(String uii){
	     if(IsPalindrome(uii)==true&&IsPalindromeChar(uii)==true){
	          System.out.println(uii+" is String palindrome.");
	     }
	     else if(IsPalindrome(uii)==true&&IsPalindromeChar(uii)==false){
	          System.out.println(uii+" is Numeric palindrome.");
	     }
	     else{
	         System.out.println(uii+" is not palindrome."); 
	     }
	}
	boolean IsPalindrome(String uii){
	     boolean isPoil=true;
	     int last = uii.length()-1;
	     for(int i=0;i<uii.length()/2;i++){
	        if(uii.charAt(i)!=uii.charAt(last)){
	           isPoil=false;
	        }
	        last--;
	     }
	     return isPoil;
	}
	boolean IsPalindromeChar(String uii){
	     boolean isPoil=true;
	     char []op = uii.toCharArray();
	     int last = uii.length()/2;
	     if(last%2==1){
	          last++;
	     }
	     for(int i=0;i<last;i++){
	        if(Character.isDigit(op[i])){
	           isPoil=false;
	        }
	        else{
	            isPoil=true; 
	        }
	     }
	     return isPoil;
	}
}
//ABCDDCBA
//4554
//123Z123
//123Z321