import java.util.Scanner;
class Ch5_ArrayH3typeA
{
    public static void main(String[] args) {
        Scanner insys = new Scanner(System.in);
        int rowX,rowY,gu,du,sum=0,cout=0,mid;
        double avg=0;
        System.out.print("input Line Y: ");
        rowY= insys .nextInt();
        System.out.print("input Line X: ");
        rowX=insys.nextInt();
        int Aui[][]=new int[rowX][rowY];
        double Bui[][] = new double[rowX][rowY];
        if(rowX%2!=0){
            mid=rowX/2+1;
        }
        else{
            mid=rowX/2;
        }
        //System.out.printf("%d \n", mid);
        for(gu=0;gu<Aui.length;gu++)
        {
            for(du=0;du<Aui[gu].length;du++)
            {
                Aui[gu][du]=(int)(Math.random()*10+1);
            }
        }
        for(gu=0;gu<Aui.length;gu++)
        {
            for(du=0;du<Aui[gu].length;du++)
            {
                if(du==mid-1){
                    //System.out.printf("%d \t", Aui[gu][du]);
                    sum+=Aui[gu][du];
                    cout++;
                }
                else if(gu==mid-1)
                {
                    //System.out.printf("%d \t", Aui[gu][du]);
                    sum+=Aui[gu][du];
                    cout++;
                }
                else if (gu==mid-1&&du==mid-1) {
                    //System.out.printf("%d \t", Aui[gu][du]);
                    sum+=Aui[gu][du]/2;
                    cout++;
                }
                else{}
            }System.out.println();
        }
        //output sec::
        System.out.println("++++");
        //System.out.println(sum+"\\"+cout+"");
        avg=(double)(sum/cout);
        for(gu=0;gu<Aui.length;gu++)
        {
            for(du=0;du<Aui[gu].length;du++)
            {
                System.out.printf("%d \t", Aui[gu][du]);
            }System.out.println();
        }
    }
}