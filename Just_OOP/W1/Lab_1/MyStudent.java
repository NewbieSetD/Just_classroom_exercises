public class MyStudent {
    public static void main(String[] args) {
        Student s1 = new Student("John", "123", null);
        s1.print();
        Student s2 = new Student("Alice", "456", s1);
        s1.setClassMate(s2);
        s1.print();
        s2.print();
    }
}
