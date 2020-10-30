package Practice14;

import Practice13.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Sort {

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void mergeSort(int[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        int[] buf = Arrays.copyOf(a, a.length);
        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }
}

class Converter
{
    public static int[] convertStudentToIdsArray(ArrayList<Student> arr){
        int[] IDs = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i){
            IDs[i] = (int)arr.get(i).getID();
        }
        return IDs;
    }
}

class Searcher{
    private static int binarySearch(int[] arr, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    private static int recBinSearch(int[] arr, int ID, int from, int to){
        if (from <= to) {
            int middle = (from+to)/2;

            if (arr[middle] > ID) {
                return recBinSearch(arr, ID, from, middle - 1);
            } else if (arr[middle] < ID) {
                return recBinSearch(arr, ID, middle+1, to);
            }
            return middle;
        }
        return -1;
    }

    public static int iterBinSearch(int[] IDs, int ID){
        return binarySearch(IDs, ID, 0, IDs.length-1);
    }

    public static int recBinSearch(int[] IDs, int ID){
        return recBinSearch(IDs, ID, 0, IDs.length-1);
    }

    public static int linearSearch(int arr[], int elementToSearch) {

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
    }
}
public class SearchTester {

    private static ArrayList<Student> prepareData(){
        ArrayList<Student> students = new ArrayList<>();
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

        return students;
    }

    private static void printData(int[] arr){
        System.out.print("[ ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(String.valueOf(arr[i])+' ');
        System.out.print(']');
        System.out.println();
    }

    public static int[] shuffleArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = prepareData(); // Подготовил входные данные
        Collections.shuffle(students); // тасую массив т.к. иначе он будет изначально ьудет отсортирован, а нам это не нужно
        int[] IDs = Converter.convertStudentToIdsArray(students); // Получаю массив айдишников в новый массив

        //Дальше комментарии показывают вывод программы
        System.out.println("Входные данные, массив айди:");
        printData(IDs); //[ 1 2 0 4 3 ]

        Sort.mergeSort(IDs,0,IDs.length-1);
        System.out.println("После сортировки слиянием:");
        printData(IDs); //[ 0 1 2 3 4 ]

        System.out.println("Перетасуем..");
        shuffleArray(IDs);
        printData(IDs);//[ 0 2 3 1 4 ]

        Sort.quickSort(IDs, 0, IDs.length-1);
        System.out.println("После быстрой сортировки");
        printData(IDs);//[ 0 1 2 3 4 ]

        System.out.println("Линейный поиск, возращает индекс элемента (-1, если не нашел)");
        System.out.println(Searcher.linearSearch(IDs,3));//3

        System.out.println("Итеративный бинарный поиск, та же логика вывода");
        System.out.println(Searcher.iterBinSearch(IDs,3));//3

        System.out.println("Рекурсивный бинарный поиск");
        System.out.println(Searcher.recBinSearch(IDs,3));//3

        /*
        Вывод: слишком малый набор данных чтобы трезво оценивать скорость работы алгоритмов

        В среднем алгоритмы слияния и быстрой сортировки работают с одинаковой скоростью = O(n*logn), но бывают случаи
        когда быстрая сортировка работает с скоростью O(n^2)

        Насчет алгоритмов поиска гораздо проще сделать вывод, так как, однозначно, выигрывает в скорости алгоритм
        бинарного поиска ( O(log(b)) vs O(n) ), однако он работает только на отсортированных массивах
         */
    }
}
