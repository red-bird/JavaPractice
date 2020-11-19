package Practice22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTester {

    public static int searchStudent(List<Student> ar, String name) throws NoSuchFieldException {
        for (int i = 0; i < ar.size(); i++){
            if (ar.get(i).getName().equals(name)){
                return i;
            }
        }
        throw new NoSuchFieldException();
    }

    public static void main(String[] args) throws NoSuchFieldException {
        List<Student> students = new ArrayList();
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

        ArrayList<Comparable> st = new ArrayList<Comparable>();
        st.addAll(students);

        Collections.sort(students);
        students.forEach(student -> System.out.println(student));

        System.out.println("\nИщем студента Lena");
        try{
            System.out.println(students.get(searchStudent(students, "Lena")));
        }
        catch (NoSuchFieldException ex){
            System.out.println("Ошибка: " + ex);
        }

        System.out.println("\nИщем студента Afanasy");
        try{
            System.out.println(students.get(searchStudent(students, "Afanasy")));
        }
        catch (NoSuchFieldException ex){
            System.out.println("Ошибка: " + ex);
        }

        //Вывод работы программы:

//        Student{ID=3, GPA=2.0, name='Kirill'}
//        Student{ID=4, GPA=2.4, name='Gregory'}
//        Student{ID=2, GPA=3.1, name='Lena'}
//        Student{ID=1, GPA=3.3, name='Vova'}
//        Student{ID=0, GPA=4.0, name='Ivan'}
//
//        Ищем студента Lena
//        Student{ID=2, GPA=3.1, name='Lena'}
//
//        Ищем студента Afanasy
//        Ошибка: java.lang.NoSuchFieldException

    }

}
