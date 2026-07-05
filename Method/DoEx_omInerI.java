import java.util.Scanner;
class DoEx_omInerI 
{
	 String dataInline(){
        Scanner ins = new Scanner(System.in);
        return ins.nextLine();
    }
    int dataline(){
        Scanner ins = new Scanner(System.in);
        return ins.nextInt();
    }
    public static void main(String[] args) {
        DoEx_omInerI fun = new DoEx_omInerI();
        int index = fun.dataline();
        String data[] = new String[index];
        String IsSquare[] = new String[index];
        for(byte i=0;i<data.length;i++){
            data[i] = fun.dataInline();
        }
        for(byte i=0;i<data.length;i++){
            IsSquare[i] = fun.IsSquareIntline(data[i]);
        }
        for(byte i=0;i<IsSquare.length;i++){
            System.out.println(IsSquare[i]);
        }
        
    }
    String IsSquareIntline(String data){
          String none[]= data.split(" ");
            if(IsRtigh(none)){
                return "Yes";
            }else{
                return "No";
            }
    }
    boolean IsRtigh(String data[]){
        boolean IsIt=true;
        int number [] = new int [data.length];
        int Isnum = 0;
        for(byte i=0;i<number.length;i++){
            number[i] = Integer.parseInt(data[i]);
        }
        Isnum = number[0];
        for(byte i=0;i<number.length;i++){
            if(Isnum!=number[i]){
                IsIt= false;
                break;
            }
            else{
               IsIt= true; 
            }
        }
        return IsIt;
    }
}
