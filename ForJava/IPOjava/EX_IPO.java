import java.util.Scanner;
class EX_IPO
{
	public static void main(String[] args) 
	{
		Scanner ins = new Scanner(System.in);
		int numI=0,numII=0;
		numI = ins.nextInt();
		numII = ins.nextInt();
		for (;numI<=numII;numI++ )
		{
			System.out.printf("%d ",numI);
		}
		System.out.println();
	}
}  
