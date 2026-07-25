//package Just_OOP.W3;
public class Children extends People{
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
//     public String getWorkplace(){
//         return super.getWorkplace();
//     }
//     public boolean equals(Object obj){}
//     public String respectTo(People p){}
 }
