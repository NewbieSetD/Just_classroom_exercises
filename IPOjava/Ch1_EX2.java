import java.util.Scanner;
class Ch1_EX2 
{
	public static void main(String[] args) 
	{
		int sum,one,two,three;
		Scanner scan = new Scanner(System.in);
		System.out.print("Input your number(1): ");
		one = scan.nextInt();
		System.out.print("Input your number(2): ");
		two = scan.nextInt();
		System.out.print("Input your number(3): ");
		three = scan.nextInt();
		sum = one + two + three;
		if(sum<=10)
		{
			System.out.println("MIDDE");
		}
		else if(sum >=12)
		{
			System.out.println("HIGH");
		}
		else
		{
			System.out.println("LOW");
		}
	}
}
