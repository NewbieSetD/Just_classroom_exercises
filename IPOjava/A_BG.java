import java.util.Scanner;
import java.util.InputMismatchException;
public class A_BG
{
	public static void main(String[] args) 
	{
		Scanner ins = new Scanner(System.in);
		int numI=0,numII=0;
		for (; ; )
		{
			try
			{
			numI=ins.nextInt();
			break;
			}
			catch (InputMismatchException err)
			{
				System.out.println(err);
				ins.nextLine();
			}
		}
		for (; ; )
		{
			try
			{
		   numII=ins.nextInt();
			break;
			}
			catch (InputMismatchException err)
			{
				System.out.println(err);
				ins.nextLine();
			}
			//int pow(10,9)
		}
		if ((numI>0&&numI<Math.pow(10,9))&&(numII>0&&numII<Math.pow(10,9)))
		{
			System.out.println(numI+numII);
		}
		else if (numII==0)
		{
			System.out.println(numI);
		}
		else if (numI==0)
		{
			System.out.println(numII);
		}
		else {
			System.out.println("Unkonwe");
		}
		
	}
}
