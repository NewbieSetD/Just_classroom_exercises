import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
public class ReadIngTXT {
    // UnDone
    ArrayList<Integer> DataMine = new ArrayList<>();
    // public static void main(String[] args){
    //     ReadIngTXT read = new ReadIngTXT();
    //     ReadFile(read.DataMine);
    //     System.out.println(read.DataMine.size());

    // }
    public static void ReadFile(ArrayList<Integer> DataMine){
        String huhu="";
        File DataFlie = new File("pm2.5_69.txt");
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
    public ArrayList<Integer>  getDataPM(){
        return DataMine;
    }
    @Override
    public String toString(){
        return "DataFlie";
    }
}