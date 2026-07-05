class Pyramid  
{
	public static void main(String[] args) 
	{
		int num=5;
		//System.out.println("Hello World!");
		for (byte i=0;i<num ;i++)
		{
			for (byte j=0;j<num-i ;j++ )
			{
				System.out.print(" ");
			}
			for (byte k=0;k<i;k++ )
			{
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
