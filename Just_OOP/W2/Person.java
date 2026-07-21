import java.util.Arrays;
class Person{
    public String   name="";
    public  char     gender=' ';
    public  String  telno="";
    public  Person  fan;
    public Person[] gig = new Person[2];
    Person(String name){
        this.name = name;
    }
    Person(String name, char gender, String telno) {
        this.name = name;
        this.gender = gender;
        this.telno = telno;
    }
    public String toString(){
        return  "Name::"    +name;
    }
    public String getPersonInfo(){
        return "=====================================" +
                "\n"+
                "Name::" +name +
                "\nGender::" +gender +
                "\nPhone Number::" +telno+
                "\nFan::" +fan.name+
                "\nGig::" +getGig()+
                "\n=====================================";
    }
    public String getPhoneNumber(Person p){
            if(gender == p.gender){
                return "No,i'dnot want to call a person with the same gender";
            }
            return "number::" +p.telno;
    }
    public String isHaveFan(Person p){
        if(fan == p){
            return "Yes, I have a fan";
        }
        return "No, I don't have a fan";
    }
    public void setFan(Person p){
        if(gender == p.gender){
            System.out.println("No,i'dnot want to have a fan with the same gender");
            return;
        }
        else if(fan != null){
            System.out.println("No, I already have a fan");
            return;
        }
        fan = p;
        System.out.println("Fan is set "+p.name);

    }
    public String getFan(Person p){
        if(fan == p){
            return"i love you "+fan.name;
            
        }
        return "No,I don't have a fan";     
    }
    public void setGig(Person p){
        for(int i=0;i<gig.length;i++){
            if(gender == p.gender){
                System.out.println("No,i'dnot want to have a gig with the different gender");
               return; 
            }
            else if(gig[i] == null&&fan != p&&gender != p.gender){
                gig[i] = p;
                System.out.println("Gig is set");
                return;
            }
        }
        System.out.println("Gig is full");
    }
    public String getGig(Person p){
        String gigList = "";
        if(gender != p.gender){
            return "No, I don't have a gig";
        }
        for(int i=0;i<gig.length;i++){
            if(gig[i] != null){
                gigList += gig[i].name + " ";
            }
        }
        return gigList;
    }
    private String getGig(){
        String gigList = "";
        for(int i=0;i<gig.length;i++){
            if(gig[i] != null){
                gigList += gig[i].name + " ";
            }
        }
        return gigList;
    }
    public void removeGig(Person p){
        for(int i=0;i<gig.length;i++){
            if(gig[i] == p){
                gig[i] = null;
                System.out.println("Gig is removed");
                return;
            }
        }
        System.out.println("Gig is not found");
    }
    public void removeGig(){
        Arrays.fill(gig, null);
        System.out.println("All gigs are removed");
    }
}
