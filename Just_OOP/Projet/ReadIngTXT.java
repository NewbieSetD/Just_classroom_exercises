import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
public class ReadIngTXT {
    // UnDone
    ArrayList<Integer> DataMine = new ArrayList<>();
    
    public static void main(String[] args) {
         File DataFlie = new File("pm2.5_69.txt");
         ReadIngTXT read = new ReadIngTXT();
         ReadFile(DataFlie,read.DataMine);
        GetVarInt get = new GetVarInt(read.DataMine);
        get.fetchOne();
    }
    public static void ReadFile(File DataFlie, ArrayList<Integer> DataMine){
        String huhu="";
        try{
        Scanner Rening = new Scanner(DataFlie);
            while(Rening.hasNext()){
            huhu=Rening.next();
            // System.out.println(huhu);

            DataMine.add(Integer.parseInt(huhu));
            }
            Rening.close();
        }
        
        catch (Exception e){
            System.out.println(e);
        }
    }
}