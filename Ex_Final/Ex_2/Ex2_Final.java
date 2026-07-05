import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
class Ex2_Final
{
	void ScFlie(File Input,ArrayList<String> Inline){
		String Inuu="";
		try
		{
			Scanner scFile = new Scanner(Input);
			for (;scFile.hasNext() ; )
			{
				Inuu=scFile.next();
				if (Inuu.equals("stop")|| Inuu.equals("Stop") || Inuu.equals("STOP"))
				{
					break;
				}
				//System.out.println(Inuu);
				Inline.add(Inuu);
			}
			scFile.close();
		}
		catch (FileNotFoundException kiki)
		{System.out.println(kiki);}
	}
	public static void main(String[] args) 
	{
		Ex2_Final def = new Ex2_Final();
		String nFile="Ex2_read.txt";
		File Input = new File(nFile);
		int All;
		ArrayList<String> Inline = new ArrayList<>();
		ArrayList<String> Outline = new ArrayList<>();
		ArrayList<Integer> Cout = new ArrayList<>();
		def.ScFlie(Input,Inline);
		//System.out.println(Inline);
		def.Iscontan(Inline,Outline);
		System.out.println(Outline);
		def.Iscout(Inline,Outline,Cout);
		All = Outline.size();
		System.out.println(Cout);
		//System.out.println(All);
		def.DownToFile(Input,All,Outline,Cout);
	}
	void Iscontan(ArrayList<String> Inline,ArrayList<String> Outline){
		String nameA="";
		for (byte i=0;	i<Inline.size() ;i++ )
		{
			if (Outline.contains(Inline.get(i)))
			{
				nameA="";
			}
			else{
				nameA = Inline.get(i);
				Outline.add(nameA);
			}
		}
	}
	void Iscout(ArrayList<String> Inline,ArrayList<String> Outline,ArrayList<Integer> Cout){
		String nameB="",nameM="";
		int cout[]=new int[Outline.size()];
		for (byte k=0;k<Outline.size() ;k++ )
		{
			nameB=Outline.get(k);
			//System.out.println(nameB);
			for (byte i=0;i<Inline.size() ;i++ )
			{
				if (nameB.equals(Inline.get(i)))
				{
					//System.out.println(nameB);
					cout[k]++;
				}
			}
			Cout.add(cout[k]);
		}
	}
	void DownToFile(File Output,int AllAnd,ArrayList<String> Outline,ArrayList<Integer> Cout){
		try
		{
			FileWriter Weter = new FileWriter(Output,true);
			Weter.write("\n"+AllAnd+" Animal \n");
			for (byte k=0;k<Outline.size() ;k++ )
			{
				Weter.write(Outline.get(k)+"\t"+Cout.get(k)+"\n");
				
			}Weter.close();
		}
		catch (IOException huhu)
		{}
	}
}
