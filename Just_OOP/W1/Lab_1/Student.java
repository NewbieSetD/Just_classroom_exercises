public class Student{
    String name;
    String id;
    Student classMate;
    Student(String Name, String Id,Student ClassMate){
        name = Name;
        id = Id;
        classMate = ClassMate;
    }
    void setClassMate(Student sm){
        classMate = sm;
    }
    void print(){
        if(classMate == null){
            System.out.println("He is Alone");
            System.out.println("Name = " + name + " /Id = " + id);
            System.out.println("========================================+");
        }
        else{
            System.out.println("Name = " + name + " /Id = " + id+" classMate = " + classMate.name);
            System.out.println("========================================+");
        }
        
    }
}