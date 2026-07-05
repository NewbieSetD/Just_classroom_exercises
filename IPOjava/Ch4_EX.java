import java.util.*;
class Ch4_EX 
{
	public static void main(String[] args) 
	{
		float sale,pay;
		Scanner scan=new Scanner (System.in);
		System.out.print("Price: ");
		int price=scan.nextInt();
		System.out.println("******************************************");
		pay = (float)price*30/100;
		sale = (float)price-pay;
		System.out.println("Pay: "+pay);
		System.out.println("Sale: "+sale);
	}
}
