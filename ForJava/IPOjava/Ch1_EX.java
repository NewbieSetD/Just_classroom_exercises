import java.util.*;
class Ch1_EX
{
	public static void main(String[] args) 
	{
		//2
		int a,b,c,f,r,u;
		float e;
		Scanner scan = new Scanner(System.in);
		System.out.print("input number(1) :");
		a = scan.nextInt();
		System.out.print("input number(2) :");
		b = scan.nextInt();
		c=a+b;
		f=a-b;
		e=a/b;
		r=a*b;
		u=a%b;
		System.out.println(a+"+"+b+"="+c);
		System.out.println(a+"-"+b+"="+f);
		System.out.println(a+"/"+b+"="+e);
		System.out.println(a+"*"+b+"="+r);
		System.out.println(a+"%"+b+"="+u);
	}
}
