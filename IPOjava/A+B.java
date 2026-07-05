import java.util.Scanner;
public class A_BG
{
	public static void main(String[] args) 
	{
		Scanner ins = new Scanner(System.in);
		for (; ; )
		{
			try
			{
			int numI=ins.nextInt();
			break;
			}
			catch (InputMismatchException err)
			{
				System.out.println(err);
			}
		}
		
		
	}
}
