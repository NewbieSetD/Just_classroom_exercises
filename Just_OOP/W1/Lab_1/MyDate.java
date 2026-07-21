public class MyDate {
    int day;
    int mouth;
    int year;
    MyDate(){
        day = 1;
        mouth = 1;
        year = 2025;
    }
    MyDate(int Day, int Month, int Year){
         day = Day;
        mouth = Month;
        year = Year;   
    }
    public void setDay(int d){
        if (d<=31&&d>=0) {
            day = d;
        }
        else{
            System.out.println("::Error,Day::");
            day = 0;
        }
        
    }
    public void setMonth(int m){
        
        if (m<=12&&m>=0) {
            mouth = m;
        }
        else{
            System.out.println("::Error,Mouth::");
            mouth = 0;
        }
    }
    public void setYear(int y){
        year = y;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return mouth;
    }
    public int getYear(){
        return year;
    }
    void date_print(){
        int Day,Mouths,years;
        Day = getDay();
        Mouths = getMonth();
        years = getYear();
        System.out.printf("Day = %d /Mouth =  %d /Years =  %d \n",Day,Mouths,years);
        System.out.println("========================================+");
    }
    /*static void main(){
        System.out.println("Hello world");
    }*/
}