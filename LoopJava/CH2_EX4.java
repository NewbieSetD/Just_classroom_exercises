import java.util.Scanner;
class CH2_EX4 
{
	public static void main(String[] args) 
	{
		short Num,sum=0;
		double avg;
		Scanner insys = new Scanner(System.in);
		for (byte round = 0;round<5 ;round++ )
		{
			System.out.print("Input NUmber: ");
			Num = insys.nextShort();
			sum+=Num;
		}
		
			avg=(double)sum/5;
		System.out.println("Sum = "+sum);
		System.out.printf("Average = %.1f",avg);
	}
}
/*
3
5
12
6
8
*/