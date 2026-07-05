import java.util.Scanner;
public class CH6_EX3
{
     int[] getMidSc(int Id){
          int MC[] = new int[Id];
          for (int Du=0;Du<MC.length ;Du++ )
          {
               MC[Du] = (int)(Math.random()*50+1);
          }
          return MC;
     }
     int[] getFinSc(int Id){
          int FC[] = new int[Id];
          for (int Du=0;Du<FC.length ;Du++ )
          {
               FC[Du] = (int)(Math.random()*50+1);
          }
          return FC;
     }
	public static void main(String[] args) {
	     CH6_EX3 qwe = new CH6_EX3();
	     Scanner ins = new Scanner(System.in);
	     int index;
	     System.out.print("Input Index: ");
	     index = ins.nextInt();
	     int mid[]=new int[index];int fin[] = new int[index];
	     int sumSc[] = new int [index];
	     char gder [] = new char [index];
	     mid = qwe.getMidSc(index);
	     fin = qwe.getFinSc(index);
	     sumSc = qwe.getSum(index,mid,fin);
	     gder=qwe.IsGrade(index,sumSc);
	     qwe.OutLine(mid,fin,sumSc,gder);
	}
	int[] getSum(int Id,int[]Mid,int[]Fin){
	     int sum[] = new int[Id];
	     for (int Du=0;Du<sum.length ;Du++ )
          {
               sum[Du] = Mid[Du] + Fin[Du];
          }
	     return sum;
	}
	char[] IsGrade(int Id,int sum[]){
	     char []grade = new char[Id];
	     for (int Du=0;Du<grade.length ;Du++ ) {
	          if (sum[Du]<50)
	          {
	             grade[Du]='f';  
	          }
	          else if (sum[Du]<60)
	          {
	               grade[Du]='d';
	          }
	          else if(sum[Du]<70){
	               grade[Du]='c';
	          }
	          else if(sum[Du]<80){
	               grade[Du]='b';
	          }
	          else{
	               grade[Du]='a';
	          }
	     }
	     return grade;
	}
	void OutLine(int []mid,int[]fin,int[]sum,char[]grade){
	     System.out.println("Mid:");
	     for (int Du=0;Du<mid.length ;Du++ ) 
	     {
	          System.out.printf("%d \t ",  mid[Du]);
	     }System.out.println();
	     System.out.println("Fin:");
	     for (int Du=0;Du<fin.length ;Du++ ) 
	     {
	          System.out.printf("%d \t ",  fin[Du]);
	     }System.out.println();
	     System.out.println("Sum:");
	     for (int Du=0;Du<sum.length ;Du++ ) 
	     {
	          System.out.printf("%d \t ",  sum[Du]);
	     }
	     System.out.println();
	     System.out.println("Grade:");
	     for (int Du=0;Du<grade.length ;Du++ ) 
	     {
	          System.out.printf("%C \t ",  grade[Du]);
	     }
	}
}
