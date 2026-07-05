import java.util.Scanner;
public class TestMe {
  public static void main(String args[]) {
      Scanner ins = new Scanner(System.in);
      TestMe fun = new TestMe();
      byte amout;
      float sum=0,maxC=0,maxP=0;
      System.out.print("Input: ");
      amout = ins.nextByte();
      String []Lcncar = new String[amout];
      String []TyoeCar = new String[amout];
      float Weiht[] = new float[amout];
      float cost[] = new float [amout];
      float pay[] = new float [amout];
      int [] Fee = new int[amout];
      for(byte it=0;it<Lcncar.length;it++){
          System.out.println("Input: ("+it+")");
          Lcncar[it]=ins.next();
          Weiht[it]=ins.nextFloat();
      }System.out.println();
      TyoeCar = fun.isTYPE(amout,Weiht);
      Fee = fun.getFEE(amout,Weiht);
      cost = fun.getCost(Fee,Weiht,cost);
      pay = fun.getPASS(Fee, cost, pay);
      sum = fun.getSum(sum,pay);
      maxC =fun.getMax(maxC,cost);
      maxP = fun.getMax(maxP,pay);
      fun.setOutlin(sum,maxC,maxP,Lcncar,Weiht,TyoeCar,Fee,cost,pay);
  }
  String[] isTYPE(byte Id,float []car){
      String []Type = new String[Id];
       for(byte it = 0;it<car.length;it++){
            if(car[it]>=0.75&&car[it]<=1.74){
                Type[it] ="CAR";
            }
            else if(car[it]>=1.75&&car[it]<=3.25){
               Type[it] ="VAN";
            }
            else if(car[it]>3.25&&car[it]<=5){
                Type[it] ="TRUCK";
            }
            else
            {
               Type[it]="ERRROR";
            }
       }
      return Type;
  }
  int[] getFEE(byte Id,float []car){
      int []Type = new int[Id];
       for(byte it=0;it<car.length;it++){
            if(car[it]>=0.75&&car[it]<=1.74){
                Type[it] =35;
            }
            else if(car[it]>=1.75&&car[it]<=3.25){
               Type[it] =72;
            }
            else if(car[it]>3.25&&car[it]<=5){
                Type[it] =137;
            }
            else
            {
               Type[it] =0;
            }
       }
      return Type;
  }
  float[] getCost(int []Fee,float[]Weiht,float[]cost){
      for(byte it=0;it<cost.length;it++){
          cost[it] = (float)(Fee[it] * Weiht[it]);
      }
      return cost;
  }
  float[] getPASS(int []Fee,float[]cost,float pay[]){
      for(byte it=0;it<pay.length;it++){
          if(Fee[it]!=0){
          pay[it] = (float)(Fee[it] + cost[it]);
          }
          else{
             pay[it] = 0 ;
          }
      }
      return pay;
  }
  float getSum(float sum ,float[]arliet){
    for(byte it=0;it<arliet.length;it++){
        sum+=arliet[it];
    }
    return sum;
  }
  float getMax(float max ,float[]arliet){
    max = arliet[0];
    for(byte it=0;it<arliet.length;it++){
        if (max<arliet[it]) {
            max = arliet[it];
        }
    }
    return max;
  }
  void setOutlin(float sum,float maxC,float maxP,String []Lcncar,float[]Weiht,String []TyoeCar,int []Fee,float []cost,float[]pay){
      for(byte it=0;it<Lcncar.length;it++)
      {
          System.out.printf("%s\t%.2f\t%10S\t%10d\t%10.2f\t%10.2f\n",Lcncar[it],Weiht[it],TyoeCar[it],Fee[it],cost[it],pay[it]);
      }
      System.out.println("===================================================================================");
      System.out.printf("%60.2f\t\t%.2f\n",maxC,maxP);
      System.out.printf("%60.2f\n",sum);
  }
}
/*
5
A123 0.8
Z007 5.5
K741 1.5
P325 2.7
G452 0.3
=+=
11
F016 0.9
Q276 1.5
U524 1.75
S026 0.87
B433 2.22
R617 2.55
V433 1.96
L038 3.2
B999 4.3
X831 4.2
Z433 0.53
 */
 