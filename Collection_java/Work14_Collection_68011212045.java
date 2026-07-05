import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
class Work14_Collection_68011212045 
{
	void InLine(ArrayList<String> nam,ArrayList<Integer> MiD,ArrayList<Integer> FiA){
		Scanner ins = new Scanner(System.in);
		int i=0,Midi=0,Fin=0;
		String name;
		for (; ; )
		{
			i++;
			System.out.printf("Name[%d]:: ",i);
			name = ins.next();
			if (name.equals("stop")||name.equals("Stop"))
				{
					break;
				}
			nam.add(name);
			for(; ;){
				try
				{
				
					System.out.printf("Midterm[%d]:: ",i);
					Midi = ins.nextInt();
					MiD.add(Midi);
					break;
				}
				catch (InputMismatchException kiki)
				{
					System.out.println("Unkown Input::"+kiki.getMessage()+"::Just Input again");
					ins.nextLine();
				}
			}
			for(;;){
				try
				{
					System.out.printf("Fianl[%d]:: ",i);
					Fin = ins.nextInt();
					FiA.add(Fin);
					break;
				}
				catch (InputMismatchException kiki)
				{
					System.out.println("Unkown Input::"+kiki.getMessage()+"::Just Input again");
					ins.nextLine();
				}
			}

		}
	}
	public static void main(String[] args) 
	{
		Work14_Collection_68011212045 fun = new Work14_Collection_68011212045();
		ArrayList<String> nameSTD = new ArrayList<String>();
		ArrayList<Integer> Midterm = new ArrayList<Integer>();
		ArrayList<Integer> Fianl = new ArrayList<Integer>();
		ArrayList<Integer> sumScore = new ArrayList<Integer>();
		ArrayList<Character> grade = new ArrayList<Character>();
		fun.InLine(nameSTD,Midterm,Fianl);
		fun.setScore(Midterm,Fianl,sumScore);
		fun.setGrade(sumScore,grade);
		fun.OutLine(nameSTD,Midterm,Fianl,sumScore,grade);
	}
	void setScore(ArrayList<Integer> MiD,ArrayList<Integer> FiA,ArrayList<Integer> sum){
		int midf=0,fiaf=0,suIm=0;
		for (byte i=0;i<FiA.size();i++  )
		{
			midf=MiD.get(i);
			fiaf=FiA.get(i);
			suIm = midf+fiaf;
			sum.add(suIm);
		}
	}
	void setGrade(ArrayList<Integer> Score,ArrayList<Character> Isgrade){
		for (byte i=0;i<Score.size();i++  )
		{
			if (Score.get(i)<50)
			{
				Isgrade.add('F');
			}
			else if(Score.get(i)<60)
			{
				Isgrade.add('D');
			}
			else if (Score.get(i)<70)
			{
				Isgrade.add('C');
			}
			else if(Score.get(i)<80)
			{
				Isgrade.add('B');
			}
			else
			{
				Isgrade.add('A');
			}

		}
	}
	void OutLine(ArrayList<String> nam,ArrayList<Integer> MiD,ArrayList<Integer> FiA,ArrayList<Integer> Score,ArrayList<Character> grade){
		System.out.println("=============================================================");
		System.out.printf("%S\t%S\t%S\t%S\t%S\n","Name","midterm","final","score","grade");
		for (byte i=0;i<nam.size();i++  )
		{
			String name =  nam.get(i);
			int Mdi =  MiD.get(i);
			int Fin =  FiA.get(i);
			int Scoe =  Score.get(i);
			char gade =  grade.get(i);
			System.out.printf("%s\t%d\t%d\t%d\t%C\n",name,Mdi,Fin,Scoe,gade);
		}
	}
}
/*
ss 24 35
poi 27 45
goft 51 32
farm 41 2
timm 25 40
dome 27 25
*/