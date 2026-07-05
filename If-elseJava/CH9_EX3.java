import java.util.Scanner;
class CH9_EX3 
{
	public static void main(String[] args) 
	{
		String Day="";
		byte inday,dayC;
		Scanner insys = new Scanner(System.in);
		System.out.print("Input your Day : ");
		inday = insys.nextByte();
		dayC = inday;
		if(inday>7)
		{
			dayC = (byte)(inday % 7);
		}
		switch(dayC){
			case 1:
			Day = "Friday";
			break;
			case 2:
			Day = "Saturday";
			break;
			case 3:
			Day = "Sunday";
			break;
			case 4:
			Day = "Monday";
			break;
			case 5:
			Day = "Tuesday";
			break;
			case 6:
			Day = "Wednesday";
			break;
			case 7:
			Day = "Thursday";
			break;
		}
		System.out.print("To day is "+Day);
		System.out.println(" and "+inday);
	}
}
