import java.util.Random;
class CH5_EX4 
{
	public static void main(String[] args) 
	{
		short numX,ronudOD=0,ronudEV=0;
		Random find = new Random();
		for (short i=1 ;i<=10 ;i++ )
		{
			numX = (short)find.nextInt(11);
			System.out.printf("%d \t",numX);
			if (numX%2==0)
			{
				ronudEV++;
			}
			else
			{
				ronudOD++;
			}
		}
		System.out.printf("\n");
		System.out.println(ronudEV+" EVEN Number");
		System.out.println(ronudOD+" ODD Number");
		
	}
}
