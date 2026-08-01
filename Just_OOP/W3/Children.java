//package Just_OOP.W3;
public class Children extends People implements GoodChild {
    private People father;
    private People mother;
    private String school;
    Children(String name, char gender, People father,People mother){
        super(name, gender);
        this.father=father;
        this.mother=mother;
    }
    Children(String name, char gender, People father,People mother, String school){
        this(name,gender,father,mother);
        this.school=school;
    }
    @Override
    public String toString(){
        String Body="";
        if(gender=='M'){
            Body="(Boy.)";

        }
        else{
            Body="(Girl.)";
        }
        
        return "Children [name="+name+", gender is="+Body+", school="+school+"]";}
        public People getFather(){
            return father;
        }
        public People getMother(){
            return mother;
        }
        @Override
        public String getWorkplace(){
            return school;
        }
        @Override
        public boolean equals(Object obj){
            if(obj == this.mother){
                System.out.println("This is the mother of "+this.name);
                return true;
            }else{
                System.out.println("This is not the mother of "+this.name);
                return false;
            }
        }
     public String respectTo(People ple){
        String politeSuffix = (gender=='M')? "Sir" : "Ma'am";
        if(ple == this.father){
            return "How are you "+politeSuffix+" Dad "+getFather();
        }
        else if(ple == this.mother){
            return "How are you "+politeSuffix+" Mom "+getMother();
        }
        else{
            return "Hello "+politeSuffix;
        }
     }
 }
