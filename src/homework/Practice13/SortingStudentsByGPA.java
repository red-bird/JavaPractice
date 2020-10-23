package homework.Practice13;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGPA() < o2.getGPA()) return 1;
        if (o2.getGPA() < o2.getGPA()) return -1;
        return 0;
    }


}
