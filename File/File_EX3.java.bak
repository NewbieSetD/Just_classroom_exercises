import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
class File_EX3 
{
	void InputFile(ArrayList<String> Code,ArrayList<String> name,ArrayList<String> Lname,ArrayList<String> All,ArrayList<String> Mid,ArrayList<String> Fin,ArrayList<String> Grade,File InFile){
		try
		{
			String huhu="";
			Scanner ins = new Scanner(InFile);
			while (ins.hasNextLine())
			{
					huhu=ins.nextLine();
					System.out.println(huhu);
			}
			ins.close();
		}
		catch (FileNotFoundException uuiiu)
		{System.out.println(uuiiu);}
	}
	public static void main(String[] args) 
	{
		File_EX3 def = new File_EX3();
		String NameFile = "Ex_3.xls";
		File InFile = new File(NameFile);
		ArrayList<String> Code = new ArrayList<>();
		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> Lname = new ArrayList<>();
		ArrayList<String> Mid = new ArrayList<>();
		ArrayList<String> Fin = new ArrayList<>();
		ArrayList<String> All = new ArrayList<>();
		ArrayList<String> Grade = new ArrayList<>();
		def.InputFile(Code,name,Lname,All,Mid,Fin,Grade,InFile);
		//System.out.println(Mid);
		//System.out.println(Fin);
		
	}
}
