import java.util.Arrays;
import java.util.Scanner;
public class EX_Q2_Spot
{
	String scInline() {
		Scanner ins = new Scanner(System.in);
		return ins.next();
	}
	char scIncharAt() {
		Scanner ins = new Scanner(System.in);
		return ins.next().charAt(0);
	}
	void setArray(char [][]Ary,char UI) {
		for(byte i=0; i<Ary.length; i++) {
			Arrays.fill(Ary[i],UI);
		}
	}
	void setArray(boolean [][]Ary) {
		for(byte i=0; i<Ary.length; i++) {
			Arrays.fill(Ary[i],false);
		}
	}
	public static void main(String[] args) {
		EX_Q2_Spot fun = new EX_Q2_Spot();
		int IDe=6,InDS=9;
		char fistsit[][]=new char [IDe][InDS];
		boolean Tack1[][] = new boolean [IDe][InDS];
		int Line,coumun,sumdo=0;
		System.out.println("Set Up!");
		System.out.print("Input Char is you want: ");
		char setsign = fun.scIncharAt();
		fun.setArray(fistsit,setsign);
		fun.setArray(Tack1);
		for(;;) {
			fun.printOut(fistsit);
			System.out.println("A sit!");
			System.out.print("Menu: ");
			char Menu = fun.scIncharAt();
			if(Menu=='e'||Menu=='E') {
				fun.printOut(fistsit);
				sumdo = fun.getSum(sumdo,Tack1);
				System.out.println(sumdo+" People BOOHING for Fly BY KuboTa747");
				break;
			}
			else if(Menu=='b'||Menu=='B'){
			System.out.print("Row:");
			char Sitrow = fun.scIncharAt();
			System.out.print("Cot:");
			String locSit = fun.scInline();
			Line = fun.getNumberRow(Sitrow);
			//System.out.println(Line);
			fun.getSit(Line,locSit,Sitrow,IDe,InDS,Tack1,fistsit);
			}
			else{
				System.out.println("Input Unknow");
				break;
			}
		}
		


	}
	void getSit(int line,String Loc,char li,int IDe,int InDS,boolean [][]Tary,char[][]Ary) {
		int x = Integer.parseInt(Loc);
		if(line>=IDe || (x>=InDS||x<0)) {
			System.out.printf("SEAT %C%d NOT HAVE\n",li,x);
		}
		else if(Tary[line][x]==true) {
			System.out.printf("SEAT %C%d NOT Empty\n",li,x);
		}
		else if(Tary[line][x]==false) {
			Ary[line][x]='X';
			Tary[line][x]=true;
		}
		else{
		     System.out.printf("SEAT %C%d NOT HAVE",li,Loc);
		}

	}
	int getSum(int sum,boolean uty[][]) {
		for(byte i=0; i<uty.length; i++) {
			for(byte j=0; j<uty[i].length; j++) {
				if(uty[i][j]==true) {
					sum++;
				}
			}
		}
		return sum;
	}
	int getNumberRow(char InpuRow) {
		if(InpuRow=='a'||InpuRow=='A') {
			return 0;
		}
		else if(InpuRow=='b'||InpuRow=='B') {
			return 1;
		}
		else if(InpuRow=='c'||InpuRow=='C') {
			return 2;
		}
		else if(InpuRow=='d'||InpuRow=='D') {
			return 3;
		}
		else if(InpuRow=='e'||InpuRow=='E') {
			return 4;
		}
		else if(InpuRow=='f'||InpuRow=='F') {
			return 5;
		}
		else  {
			return 10;
		}
	}
	void printOut(char[][]hu) {
	     int o=65;
	     char ui=(char)(o);
	     System.out.println("Welcome to DumDin AirKine BY KuboTa747");
	     System.out.printf("  "); 
	     for(byte i=0; i<hu[0].length; i++){
	        System.out.printf("%4d",i);  
	     }System.out.println();
	     System.out.println("====================================================================");
	     
		for(byte i=0; i<hu.length; i++) {
		     System.out.printf("%C|",ui);
			for(byte j=0; j<hu[i].length; j++) {
				System.out.printf("%4c",hu[i][j]);
			}
			System.out.println();
			if(i==hu.length/2-1) {
				System.out.println();
			}
			o++;
			 ui = (char)(o);
		}
		System.out.println("====================================================================");
	}
}