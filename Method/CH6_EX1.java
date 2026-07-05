import java.util.Scanner;
public class CH6_EX1
{
     int getMid(){
          Scanner inss = new Scanner(System.in);
          System.out.print("Input Mid: ");
          int sorc = inss.nextInt();
          return sorc;
     }
     int getFnal(){
          Scanner inss = new Scanner(System.in);
          System.out.print("Input Mid: ");
          int sorc = inss.nextInt();
          return sorc;
     }
	public static void main(String[] args) //Main
	{
	     CH6_EX1 qwe = new CH6_EX1();
		int sM,sF,sum;
		char Gd =' ';
		for (; ; ) {
		sM=qwe.getMid();
		sF=qwe.getFnal();
		sum=qwe.getSumSorc(sM,sF);
		Gd=qwe.getGarde(sum);
		qwe.outPut(sM,sF,sum,Gd);
		}
	}
	int getSumSorc(int M,int F){
	     int sum = M+F;
	     return sum;
	}
	char getGarde(int sum){
	     char grade=' ';
	     if (sum>=70){
	          grade='s';
	     }
	     else{
	          grade='u';
	     } 
	     return grade;
	}
	void outPut(int m,int f,int s,char gd){
	     System.out.printf("Mid\tFinal\tSum\tGrade\n");
	     System.out.printf("%d\t%d\t%d\t%C\n",m,f,s,gd);
	}
}
