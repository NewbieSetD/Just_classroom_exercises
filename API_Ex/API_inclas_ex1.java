import java.util.Scanner;
public class API_inclas_ex1
{
    String  scInline(){
        Scanner Ins = new Scanner(System.in);
        return Ins.nextLine();
    }
  public static void main(String args[]) {
      API_inclas_ex1 fun = new API_inclas_ex1();
     System.out.print("Input: ");
    String mass = fun.scInline();
    String mass2=mass.trim();
    char ArreyStr[] = mass2.toCharArray();
    String[] word = mass2.split(" ");
    fun.IsByorch(ArreyStr,word);
  }
  void IsByorch(char []Str,String[] wording){
      byte coutN=0,coutU=0,coutL=0,coutStr=0;
      for(byte i=0;i<Str.length;i++){
          if(Character.	isDigit(Str[i])){
              coutN++;
          }
          else if(Character.isLowerCase(Str[i])){
              coutL++;
               coutStr++;
          }
          else if(Character.isUpperCase(Str[i])){
              coutU++;
              coutStr++;
          }
      }
      OutLine(wording,coutN,coutU,coutL,coutStr);
  }
  void OutLine(String []wording,byte cN,byte cU,byte cL,byte CS){
      System.out.println(cN+ " Numeric");
      System.out.println(cL+ " Lowercase");
      System.out.println(cU+ " Uppercase");
      System.out.println(CS+ " character");
      System.out.println(wording.length+" words");
  }
  /* Hello my name is Supoat Wongsa I was born 1976 I have 36 years old.*/

}