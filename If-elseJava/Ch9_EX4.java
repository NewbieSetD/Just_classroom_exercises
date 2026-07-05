import java.util.Scanner;
class Ch9_EX4 
{
	public static void main(String[] args) 
	{
		String rank="";
		Scanner insys = new Scanner(System.in);
		rank = insys.next();
		if (rank.equals("excellent"))
		{
			System.out.println("Grade A");
		}
		else if (rank.equals("good"))
		{
			System.out.println("Grade B");
		}
		else if (rank.equals("fair"))
		{
			System.out.println("Grade C");
		}
		else if (rank.equals("pass"))
		{
			System.out.println("Grade D");
		}
		else if (rank.equals("fail"))
		{
			System.out.println("Grade F");
		}
		else
		{
			System.out.println("Grade unknown");
		}
	}
}
