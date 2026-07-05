import java.util.Scanner;
class MetDoutOne {
    int scInput(){
        Scanner ins = new Scanner(System.in);
        return ins.nextInt();
    }
  public static void main(String[] args) {
      MetDoutOne qwe = new MetDoutOne();
      System.out.printf("Money: ");
      int money = qwe.scInput();
      System.out.printf("Year: ");
      int Yaer = qwe.scInput();
      double personm=0;
      for(int i=0;i<Yaer;i++){
          if(i<=0){
              personm = (double)(qwe.IsCal(money));
          }
          else {
              personm += (double)(qwe.IsCal(personm));
          }
      }
      qwe.outLine(personm,money,Yaer);
  }
  double IsCal(int PersonM){
      double interest = (double)(PersonM*2.37/100);
        double backM = (double)(interest+PersonM);
      return backM;
  }
  double IsCal(double PersonM){
      double interest = (double)(PersonM*2.37/100);
      return interest;
  }
  void outLine(double allmoney,int M,int Y){
      System.out.printf("pLone(%d,%d,2.37) ",M,Y);
      System.out.print("= "+allmoney);
  }
}
