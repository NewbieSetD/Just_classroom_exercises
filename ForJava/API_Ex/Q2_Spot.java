import java.util.Scanner;
public class Q2_Spot//ตรวจเช็คเบอร์โทรศัพ
{
	String scInline(){
	     Scanner ins = new Scanner(System.in);
	     return ins.nextLine();
	}
	public static void main(String[] args) 
	{
		Q2_Spot fun = new Q2_Spot();
		int sum=0,Dunchi;
		for(;;){
		System.out.print("Input Number Phone:");
		String inPut = fun.scInline();
		String Phone = fun.getCleanUp(inPut);
		char [] numphone = Phone.toCharArray();
		boolean hash = fun.IsNumberPhone(numphone);
		     if(hash==false){
		          System.out.println("Incorrect");
		          break;
		     }
		     else if(Phone.charAt(0)!='0'){
		        System.out.println("Incorrect");
		          break;  
		     }
		     else if(Phone.length()!=10){
		        System.out.println("Incorrect");
		          break;  
		     }
		sum = fun.CalIsPhone(numphone);
		//System.out.println(sum);
		Dunchi=sum;
		     while(true){
		          Dunchi=fun.CallNumberPhone(Dunchi);
		          if(Dunchi<10){
		              System.out.println("Dunchi = "+Dunchi); 
		             break;        
		          }
		         //System.out.println("Dunchi = "+Dunchi); 
		     }
		     System.out.println("===================================");
		    
		    //System.out.println("Dunchi = "+Dunchi);
		}
	}
	String getCleanUp(String inPut){
	     String clean = inPut.trim();
	     String cleanx =clean.replace("-","");
	     String cleanY =cleanx.replace(" ","");
	     return cleanY;
	}
	boolean IsNumberPhone(char numphone[]){
	     boolean Mh = true;
	     for (byte i=0;i<numphone.length;i++ ) {
	          if(Character.isDigit(numphone[i])){
	               Mh = true;
	          }
	          else{
	               Mh = false;
	               break;
	          }
	     }
	     return Mh;
	}
	int CalIsPhone(char[]opC){
	     int num = 0;
		 //int hu = opC.length;
	     for (byte i=0;i<opC.length;i++ ){
	          //System.out.println("num = "+num);
	          //System.out.println("opC = "+opC[i]);
	          num += Character.digit(opC[i],10);
	     }
	     /*for(byte i=0;i<opC.length;i++){
	      System.out.println("num = "+opC[i]);    
	     }*/
	     //System.out.println("num = "+num);
	     return num;
	}
	int CallNumberPhone(int num){
	     String Phon = 	Integer.toString(num);
	     //System.out.println("Phon = "+Phon);
		 String huh  = getCleanUp(Phon);
	     char [] numphone = huh.toCharArray();
	     return CalIsPhone(numphone);
	}
}//0895835523