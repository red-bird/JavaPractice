package homework.Practice13;

import java.util.ArrayList;
import java.util.Collections;

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

        Collections.sort(students, new SortingStudentsByGPA().reversed());
        students.forEach(student -> System.out.println(student));

    }

}
