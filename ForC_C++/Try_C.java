import java.io.IOException;
class Try_C 
{
	public static void main(String[] args) 
	{
		char x =' '; //stx outside
		try
		{
			x=(char)System.in.read();//input inside
		}
		catch (IOException e)
		{}
		System.out.println(x);//output outside
	}
}
