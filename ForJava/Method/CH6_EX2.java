import java.util.Scanner;
public class CH6_EX2
{
     int getInput(){
          Scanner inss = new Scanner(System.in);
          System.out.printf("Input: ");
          return inss.nextInt();
     }
     void setOutput(int sum,float Diss,int realP){
          System.out.printf("%d\t%10.2f\t%10d",sum,Diss,realP);
     }
	public static void main(String[] args) {
		Main qwe = new Main();
		Scanner inss = new Scanner(System.in);
		int Products,sumP,realP;
		float Dis;
		sumP= qwe.getPriceProducts();
		Dis = qwe.getDisprod(sumP);
		realP = qwe.getRealprice(Dis,sumP);
	     qwe.setOutput(sumP,Dis,realP);
	}
	int getPriceProducts(){
	     int ProD,sum=0;
	     for (; ; ) {
	     ProD = getInput();
	          if (ProD<=0){
	               break; 
	          }
	         sum+=ProD;
	     }
	     return sum;
	}
     float getDisprod(int sumP){
	     float dis = (float)((sumP*3)/100);
	     return dis;
	}
	int getRealprice(float D,int S){
	     int realprice = (int)(S-D);
	     return realprice;
	}
}