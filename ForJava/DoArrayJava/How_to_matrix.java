import java.util.Arrays;
class How_to_matrix 
{
	static void GetData_Ar2D(int DLand[][])//Input Data Or Data Something
	{
        for(byte i = 0 ;i<DLand.length;i++){
            for(byte j = 0 ;j<DLand[i].length;j++){
                if(i%2==0||j%2!=0){
                   DLand[i][j] = 1;
                }
            }
        }
    }
	static void Data_Proces_Matrix(int DLand[][],int ALand[][])//Make Matrix
	{ 
        for(byte i = 0 ;i<DLand.length;i++){
            for(byte j = 0 ;j<DLand[i].length;j++){
                ALand[j][i] = DLand[i][j];
            }
        }
    }
	static void Data_Out_Matrix(int DLand[][])//OutPut Here
	{
        for(byte i = 0 ;i<DLand.length;i++){
            for(byte j = 0 ;j<DLand[i].length;j++){
                System.out.print(DLand[i][j]);
            }System.out.println();
        }
    }
	public static void main(String[] args) //Here!!
	{
		int Buat[][] = new int[5][3];
        int Auat[][] = new int[3][5];
        GetData_Ar2D(Buat);
        Data_Out_Matrix(Buat);
        Data_Proces_Matrix(Buat,Auat);
        System.out.println("========================");
        Data_Out_Matrix(Auat);
	}
}
