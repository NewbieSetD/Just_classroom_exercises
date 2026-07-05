import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException ;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
class Work15_FILE_68011212045 
{
	void Build(String FilesUSE){
		
		try
		{
			FileWriter Fweing = new FileWriter(FilesUSE);
			Fweing.write("No."+"\t"+"Name."+"\t"+"Code."+"\t"+"Midterm."+"\t"+"Final."+"\t"+"Score."+"\t"+"Grade."+"\t"+"Date."+"\n");
			IntoFile(Fweing);
		}
		catch (IOException GUru){}
		
	}
	public static void main(String[] args) 
	{
		Work15_FILE_68011212045 fun = new Work15_FILE_68011212045();
		 String FilesUSE="68011212045.xls";
		fun.Build(FilesUSE);
		fun.ReadFile(FilesUSE);
	}
	void IntoFile(FileWriter Fweing){
		int i=1,j=0,Mid,Fin;
		String NM,Da="d MMM yy-HH:mm",number,MI,FI;
		Scanner ins = new Scanner(System.in);
		try
		{
			for (; ; )
			{
				number = Integer.toString(i);
				
				System.out.print("Input Name: ");
				NM = ins.next();
					if (NM.equals("K")||NM.equals("k"))
					{
						Fweing.close();
						break;
					}
				Fweing.write(number+"\t"+NM+"\t");
				System.out.print("Input Code: ");
				Fweing.write(ins.next());
				Fweing.write("\t");
				for (; ; )
				{
					try
					{
						System.out.print("Input Midterm: ");
						Mid = ins.nextInt();
						MI = Integer.toString(Mid);
						Fweing.write(MI);
						Fweing.write("\t");
						break;
					}
					catch (InputMismatchException kiki)
					{
						System.out.println("Unkown Input::"+kiki.getMessage()+"::Just Input again");
						ins.nextLine();
					}
				}
				for (; ; )
				{
					try
					{
						System.out.print("Input Final: ");
						Fin = ins.nextInt();
						FI = Integer.toString(Fin);
						Fweing.write(FI);
						Fweing.write("\t");
						break;
					}
					catch (InputMismatchException kiki)
					{
						System.out.println("Unkown Input::"+kiki.getMessage()+"::Just Input again");
						ins.nextLine();
					}
				}
				Fweing.write(Integer.toString(SumScore(Mid,Fin)));
				Fweing.write("\t");
				Fweing.write(Grade(SumScore(Mid,Fin)));
				Fweing.write("\t");
				Fweing.write(Datety(Da));
				Fweing.write("\n");
				System.out.println("Done!");
				i++;
			}
			
		}
		catch (IOException GUru)
		{}
	}
	char Grade(int Score){
		if (Score<50)
			{
				return'F';
			}
			else if(Score<60)
			{
				return'D';
			}
			else if (Score<70)
			{
				return'C';
			}
			else if(Score<80)
			{
				return'B';
			}
			else
			{
				return'A';
			}

	}
	int SumScore(int M,int F){
		return M+F;
	}
	String Datety(String Dae){
		Locale loc = new Locale("en");
		SimpleDateFormat Tsd = new SimpleDateFormat(Dae,loc);
		//System.out.println(Tsd);
		Date Nta = new Date();
		String yuy = Tsd.format(Nta);
		return yuy;
	}
	void ReadFile(String FilesUSE){
		String Outu="";
		try
		{
			Scanner Scfile =  new Scanner(new File(FilesUSE));
			for (;Scfile.hasNext() ; )
			{
				Outu = Scfile.nextLine();
				System.out.println(Outu);
			}
		}
		catch (FileNotFoundException kiki)
		{
			System.out.println("??");
		}
		
		
	}
}
/*
Jop 670110112032 25 25
Big 650110112002 30 41
Hull 66011012111 22 45
DEPP 640221525302 34 12
Team 662112101102 37 47
Pipe 641020125421 33 22
*/