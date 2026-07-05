import java.util.*;
class  Ch6_EX
{
	public static void main(String[] args) 
	{
		float longan,sum;
		int rambutan;
		Scanner scan = new Scanner(System.in);
		System.out.print("Mango: ");
		int mango = scan.nextInt();
		longan = (float)mango*85/100;
		rambutan = (int)(longan+mango)*2;
		sum = rambutan+mango+longan;
		System.out.println("+----+----+----+----+----+----+----+----+");
		System.out.println(longan);
		System.out.println(rambutan);
		System.out.println(sum);
	}
}
