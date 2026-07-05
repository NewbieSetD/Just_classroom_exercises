class CH6_EX4 
{
	public static void main(String[] args) 
	{
		byte type=10,doit=1;
		char Sudo;
		while (doit<=10)
		{
		Sudo = (char)(Math.random()*26+65);
		 System.out.println(Sudo);
		 doit++;

		}
	}
}
