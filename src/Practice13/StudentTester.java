package Practice13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
    private static int counter = 0;
    private int ID;
    private double GPA = -1;
    private String name;

    void setGPA(double GPA){
        if (0.0 <= GPA && GPA <= 4.0)
        this.GPA = GPA;}
    void setName(String name){this.name = name;}
    int getID(){return ID;}
    double getGPA(){return GPA;}
    String getName(){return name;}

    Student(String name, double GPA){
        this.ID = counter;
        ++counter;
        setName(name);
        setGPA(GPA);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", GPA=" + GPA +
                ", name='" + name + '\'' +
                '}';
    }
}

class SortingStudentsByGPA implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGPA() < o2.getGPA()) return 1;
        if (o2.getGPA() < o2.getGPA()) return -1;
        return 0;
    }

}

public class StudentTester {

    boolean cmp(int a, int b){
        return a < b;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList();
        ArrayList iDNumber = new ArrayList();
        Student student1 = new Student("Ivan",4);
        Student student2 = new Student("Vova",3.3);
        Student student3 = new Student("Lena",3.1);
        Student student4 = new Student("Kirill",2);
        Student student5 = new Student("Gregory",2.4);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        students.forEach(student -> iDNumber.add(student.getID()));
        Collections.sort(iDNumber);
        iDNumber.forEach(id -> System.out.println(id));

        Collections.sort(students, new SortingStudentsByGPA());
        students.forEach(student -> System.out.println(student));

    }

}
