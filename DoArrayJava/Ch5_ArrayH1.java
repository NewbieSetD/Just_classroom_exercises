import java.util.Scanner;
class Ch5_ArrayH1{
    public static void main(String[] args) {
        Scanner insys = new Scanner(System.in);
        short index,gu,du,hu;
        System.out.print("input index: ");
        index = insys.nextShort();
        char Sn[]=new char[index];
        char SnS[]=new char[index+1];
        for (gu=0;gu<Sn.length;gu++) {
            Sn[gu]=(char)(Math.random()*24+65);
            SnS[gu]=Sn[gu];
        }
        System.out.println("QUEU: ");
        for (gu=0;gu<SnS.length;gu++)//output one:
            {
                try {
                Thread.sleep(100);
                } catch (InterruptedException e) {}
                System.out.printf("%c\t",SnS[gu]); 
            }System.out.println();
        for (gu=0;gu<Sn.length;gu++) {
             try {
                Thread.sleep(100);
                } catch (InterruptedException e) {}
            Sn[gu]=SnS[gu+1];
            System.out.printf("%c\t",Sn[gu]);
        }
    }
}