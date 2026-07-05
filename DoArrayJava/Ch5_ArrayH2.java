import java.util.Scanner;
class Ch5_ArrayH2{
    public static void main(String[] args) {
        Scanner inss = new Scanner(System.in);
        byte index,gu,Chk=1;
        System.err.print("input index: ");
        index = inss.nextByte();
        byte num[]= new byte [index];
        num[0] = (byte)(Math.random()*9+1);
        for (gu=1;gu<num.length;gu++) {
            num[gu] = (byte)(Math.random()*9+1);
            if (num[gu]==num[gu-Chk]) {
                num[gu]=0;
                gu--;
                Chk--;
                continue;
            }
            else{
                Chk=gu;
                continue;
            }
        }
        for (gu=0;gu<num.length;gu++){
            System.out.printf("%d \t",num[gu]);
        }
        
    }
}