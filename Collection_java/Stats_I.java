import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
class Stats_I
{
//4 5 56 34 56 67
//4 34 56 56 67
	String InLine(){
		Scanner ins = new Scanner(System.in);
		return ins.nextLine();
	}
	public static void main(String[] args) 
	{
		Stats_I fun = new Stats_I();
		ArrayList<Integer> InData = new ArrayList<>();
		System.out.print("Input: ");
		String data=fun.InLine();
		fun.Collto(data,InData);
		int sum = fun.sumAll(InData);
		int mean = fun.Domaen(sum,InData);
		int MeD = fun.FindMedian(InData);
		float Moder = fun.Moder(InData);
		float Max = fun.MaxLine(InData);
		float Min =fun.MinLine(InData);
		fun.OutLine(sum,mean,MeD,Moder,Max,Min,InData);
	}
	void OutLine(int sum,int mean,int MeD,float Moder,float MAX,float MIN,ArrayList<Integer> InData){
		System.out.print("Data ");
		for (int Data : InData)
		{
			System.out.print(" "+Data);
		}System.out.println();
		System.out.println("Sum "+sum);
		System.out.println("Mean "+mean);
		System.out.println("Median "+MeD);
		System.out.println("Mode "+Moder);
		System.out.println("Mode "+MAX);
		System.out.println("Mode "+MIN);
	}
	int MaxLine(ArrayList<Integer> InData){
		int num=InData.get(0),Max=0;
		for (byte in=0;in<InData.size() ;in++ )
		{
				Max=Integer.max(num,InData.get(in));
		}
		return Max;
	}
	int MinLine(ArrayList<Integer> InData){
		int num=InData.get(0),Min=0;
		for (byte in=0;in<InData.size() ;in++ )
		{
				Min=Integer.min(num,InData.get(in));
		}
		return Min;
	}
	void Collto(String data,ArrayList<Integer> InData){
			String[]obj = data.split(" ");
			int []objnum = new int [obj.length];
			for (byte in=0;in<obj.length ;in++ )
			{
				
				objnum[in] = Integer.parseInt(obj[in]);
			}
			Arrays.sort(objnum);
			for (byte in=0;in<objnum.length ;in++ )
			{
				
				InData.add(objnum[in]);
			}
	}
	int sumAll(ArrayList<Integer> InData){
		int sum=0;
		for (byte in=0;in<InData.size() ;in++ )
		{
			sum+=InData.get(in);
		}
		return sum;
	}
	int Domaen(int sum,ArrayList<Integer> InData){
		int mean  = sum/InData.size();
		return mean;
	}
	int FindMedian(ArrayList<Integer> InData){
		int Med=0,indexII=0,indexI=0,numberME=0,numberMEI=0;
		if (InData.size()%2==1)
		{
			indexI = InData.size()/2;
			return Med = InData.get(indexI);
		}
		else{
			indexI=InData.size()/2;
			indexII=InData.size()/2-1;
			numberME=InData.get(indexI);
			numberMEI=InData.get(indexII);
			return Med = (numberME+numberMEI)/2;
		}
	}
	int Moder(ArrayList<Integer> InData){
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (byte in=0;in<InData.size() ;in++ ) {
            freq.put(InData.get(in), freq.getOrDefault(InData.get(in), 0) + 1);
        }
        int mode = InData.get(0);
        int maxCount = 0;

        for (HashMap.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                mode = e.getKey();
            }
        }
       return mode;
    } 
	
}
