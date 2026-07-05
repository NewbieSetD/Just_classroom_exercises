import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
class Ex3_Final //Done
{
	void scFile(File Nfile,ArrayList<String> Megs){
		try
		{
			Scanner ins = new Scanner(Nfile);
			for (; ins.hasNext(); )
			{
				Megs.add(ins.nextLine());
			}
			ins.close();
		}
		catch (FileNotFoundException kiki)
		{System.out.println(kiki);}
			
	}
	public static void main(String[] args) 
	{
		Ex3_Final def = new Ex3_Final();
		String Input,FileN="Ex_3_Read.txt";
		File Nfile = new File(FileN);
		ArrayList<String> Megs = new ArrayList<>();
		ArrayList<Integer> Numbb = new ArrayList<>();
		def.scFile(Nfile,Megs);
		def.Tran(Megs,Numbb);
		//System.out.println(Numbb.size());
		if (Numbb.size()>1)
		{
			//System.out.println(Megs);
			int su=def.sumInter(Megs,Numbb);
			char ope = def.OPelan(Megs,Numbb);
			def.InputFile(Numbb,ope,su,Nfile);
			//System.out.println(su);
		}
		else{
			System.out.println("Input gone");
		}
		/*
		One FIVE oNE twO NINE
		-
		Nine seveN THREE SEVEN
		*/
	}
	void Tran(ArrayList<String> Megs,ArrayList<Integer> Numbb){
		String number="";
		boolean Iswant=true;
		for (byte k =0;k<Megs.size() ;k++ )
		{
			String input = Megs.get(k);
			String tolow = input.toLowerCase();
			String Meg[]=	tolow.split(" ");
		for (byte i =0;i<Meg.length ;i++ )
		{
			//System.out.print(Meg[i]+"\t");
			if (Meg[i].equals("zero"))
			{
				number=number+"0";
				Iswant=true;
			}
			else if (Meg[i].equals("one"))
			{
				number=number+"1";
				Iswant=true;
			}
			else if (Meg[i].equals("two"))
			{
				number=number+"2";
				Iswant=true;
			}
			else if (Meg[i].equals("three"))
			{
				number=number+"3";
				Iswant=true;
			}
			else if (Meg[i].equals("four"))
			{
				number=number+"4";
				Iswant=true;
			}
			else if (Meg[i].equals("five"))
			{
				number=number+"5";
				Iswant=true;
			}
			else if (Meg[i].equals("six"))
			{
				number=number+"6";
				Iswant=true;
			}
			else if (Meg[i].equals("seven"))
			{
				number=number+"7";
				Iswant=true;
			}
			else if (Meg[i].equals("eight"))
			{
				number=number+"8";
				Iswant=true;
			}
			else if (Meg[i].equals("nine"))
			{
				number=number+"9";
				Iswant=true;
			}
			else{
				Iswant=false;
			}
			//System.out.println(number);
		}
			if (Iswant)
			{
				Numbb.add(Integer.parseInt(number));
			}
			number="";
		}
	}
	int sumInter(ArrayList<String> Megs,ArrayList<Integer> Numbb){
		int sum=0;
		char ope=' ';
			for (byte i=0;i<Megs.size() ;i++)
			{
				if (Megs.get(i).equals("/"))
				{
				ope='/';
				break;
				}
				else if (Megs.get(i).equals("*") )
				{
				ope='*';
				break;
				}
				else if (Megs.get(i).equals("-"))
				{
				ope='-';
				break;
				}
				else if (Megs.get(i).equals("+"))
				{
				ope='+';
				break;
				}
				else{
				sum=0;
				}
			}
			sum=SumAIl(sum,ope,Numbb);
		return sum;
	}
	char OPelan(ArrayList<String> Megs,ArrayList<Integer> Numbb){
		char ope=' ';
			for (byte i=0;i<Megs.size() ;i++)
			{
				if (Megs.get(i).equals("/"))
				{
				ope='/';
				break;
				}
				else if (Megs.get(i).equals("*") )
				{
				ope='*';
				break;
				}
				else if (Megs.get(i).equals("-"))
				{
				ope='-';
				break;
				}
				else if (Megs.get(i).equals("+"))
				{
				ope='+';
				break;
				}
				else{
				}
			}
		return ope;
	}
	int SumAIl(int sum,char ope,ArrayList<Integer> Numbb){
		Integer number[] = Numbb.toArray(new Integer[0]);
		for (byte i=0;i<number.length ;i++)
		{
			if (ope=='/'&&i>0)
				{
					sum/=number[i];
				}
				else if (ope=='*' &&i>0)
				{
					sum*=number[i];
				}
				else if (ope=='-'&&i>0)
				{
					sum-=number[i];
				}
				else if (ope=='+'&&i>0)
				{
					sum+=number[i];
				}
				else{
					sum=number[i];
				}
		}
		return sum;
	}
	void InputFile(ArrayList<Integer> Numbb,char ope,int sum,File Nfile){
		String num;
		try
		{
			FileWriter watr = new FileWriter(Nfile,true);
			watr.write("\n");
			for (byte i=0;i<Numbb.size() ;i++)
			{
				num=Integer.toString(Numbb.get(i));
				watr.write(num);
				if (i==0)
				{
					watr.write("\t"+ope+"\t");
				}
			}
			watr.write(" = "+sum);
			watr.close();
		}
		catch (IOException kiki)
		{System.out.println(kiki);}
	}
}
