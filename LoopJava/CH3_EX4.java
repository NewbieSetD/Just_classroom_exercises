class CH3_EX4 
{
	public static void main(String[] args) 
	{
		int numbe;
		for (int i=1;i<=10 ;i++ )
		{
			numbe = (int)(Math.random()*10+1);
			if (numbe%2==0)
			{
				System.out.println(numbe+" EVEN");
			}
			else
			{
				System.out.println(numbe+" ODD");
			}
			
		}
	}
}
