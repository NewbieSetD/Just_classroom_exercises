import java.util.*;
class Ch5_EX 
{
	public static void main(String[] args) 
	{
		//8
		int numberx,powX;
		double pai,Carea,Warea,Garea;
		pai = Math.PI;
		Scanner scan = new Scanner(System.in); 
		System.out.print("X: ");
		numberx = scan.nextInt();
		powX=(int)(Math.pow(numberx,2));
		Carea = pai*powX/4;
		Warea = (float)3*powX/8;
		Garea = Carea-Warea;
		System.out.println("******************************************");
		//System.out.println(powX);
		System.out.println("Circle area: "+Carea);
		System.out.println("White area: "+Warea);
		System.out.println("Gray area: "+Garea);
		
	}
}
