class CH1_EX5
{
    public static void main(String args[])
    {
        short num=0,sumodd=0,sumeven=0;
        for (byte inrun=0 ; inrun < 10;inrun++) {
            num = (short)(Math.random()*10+1);
            if (num%2==0) {
                sumeven++;
            }
            else
            {
                sumodd++;
            }
            System.out.print(num+" ");
        }
         System.out.println(" ");
        System.out.println(sumeven+" Number can Even");
        System.out.println(sumodd+" Number can ODD");
    }
}