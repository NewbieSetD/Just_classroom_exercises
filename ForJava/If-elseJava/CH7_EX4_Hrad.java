import java.util.Scanner;
class CH7_EX4_Hrad 
{
	//แก้ยังไม่ได้
	public static void main(String[] args) 
	{
		int water,pric=0,unitI=0,allprice=0,unitII=0,pricI=0,unitIII=0;
		Scanner insys = new Scanner (System.in);
		System.out.print("input water: ");
		water = insys.nextShort();
		if (water <= 10)
		{
			allprice = water * 5;
		}
		else if (water <= 20)
		{
			unitI = water%10;
			pric = (water-unitI) * 8;
			pricI = unitI * 15; 
			allprice = pric + pricI;

		}
		else
		{
			unitI = water-20;
			pric = unitI * 50;
			unitII = 10*20;
			pricI = unitII + 10*1; 
			allprice = pric + pricI;
		}
		System.out.println("all pay: "+allprice);
		System.out.println(unitI);
		System.out.println(unitII);
		System.out.println(pric);
		System.out.println(unitII);
	}
}
