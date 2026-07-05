import java.util.Scanner;
class Ch9_2_EX4 
{
	public static void main(String[] args) 
	{
		String rank="";
		Scanner insys = new Scanner(System.in);
		rank = insys.next();
		switch (rank)
		{
		default :
			System.out.println("Grade unknown");
			break;
		case "excellent":
			System.out.println("Grade A");
			break;
		case "good":
			System.out.println("Grade B");
			break;
		case "fair":
			System.out.println("Grade C");
			break;
		case "pass":
			System.out.println("Grade D");
			break;
		case "fail":
			System.out.println("Grade F");
			break;
		}
		
	}
}
