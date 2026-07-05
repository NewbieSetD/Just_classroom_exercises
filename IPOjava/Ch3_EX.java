import java.util.*;
class Ch3_EX 
{
	public static void main(String[] args) 
	{
		int dadmoney;
		float mom,child,father;
		Scanner scan=new Scanner (System.in);
		System.out.print("Income: ");
		dadmoney = scan.nextInt();
		System.out.println("******************************************");
		mom=((float)dadmoney*45)/100;
		child = (float)dadmoney*15/100;
		father=dadmoney-(mom+child);
		System.out.println("Income: "+dadmoney);
		System.out.println("Mother: "+mom);
		System.out.println("Child: "+child);
		System.out.println("Father: "+father);
	}
}
