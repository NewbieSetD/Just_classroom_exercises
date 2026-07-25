package Just_OOP.W3;

public class Children extends People{
    private People father;
    private People mother;
    private String school;
    Children(String name, char gender, People father,People mother){
        super(name,gender);
        this.father=father;
        this.mother=mother;
    }
    Children(String name, char gender, People father,People mother, String school){
        super(name,gender);
        this.father=father;
        this.mother=mother;
        this.school=school;
    }
    public String toString(){}
    public People getFather(){
        return father;
    }
    public People getMother(){
        return mother;
    }
    public String getWorkplace(){
        return super.getWorkplace();
    }
    public boolean equals(Object obj){}
    public String respectTo(People p){}
}
