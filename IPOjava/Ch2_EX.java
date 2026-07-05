import java.util.*;
class Ch2_EX 
{
	public static void main(String[] args) 
	{
		int cost,change;
		Scanner scan = new Scanner(System.in);
		System.out.print("Product: ");
		String obj=scan.next();
		System.out.print("Price: ");
		int price=scan.nextInt();
		System.out.print("Amount: ");
		int amount=scan.nextInt();
		System.out.print("Pay: ");
		int pay=scan.nextInt();
		cost=amount * price;
		change=pay - cost;
		System.out.println("******************************************");
		System.out.println("Buy \\"+obj+"\\ Price "+price+" Amount "+amount+".");
		System.out.println("Cost: "+cost+" Bath");
		System.out.println("Pay: "+pay+" Bath");
		System.out.println("Change: "+change+" Bath");		
	}
}
