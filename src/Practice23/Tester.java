package Practice23;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Pair<K, V>{
    // Чтобы не подключать javafx, просто свою "пару" написал
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class Solution{
    public static <T> List<T> newArrayList(T[] arr){
        /**
         * Convert array of T type to list of T type
         *
         * @param arr the array to be converted
         * @return the list of T type elements
         */
        List<T> list = new ArrayList<T>();
        for (T item:
                arr) {
            list.add(item);
        }
        return list;
    }

    public static <T> HashSet<T> newHashSet(T[] arr){
        /**
         * Convert array of T type to HashSet of T type
         *
         * @param arr the array to be converted
         * @return the HashSet of T type elements
         */
        HashSet<T> hashSet = new HashSet<T>();
        for (T item:
                arr) {
            hashSet.add(item);
        }
        return hashSet;
    }

    public static <K, V> HashMap<K,V> newHashMap(Pair<K,V>[] arr){
        /**
         * Convert array of Pair<K,V> to list of T type
         *
         * @param arr the array to HashMap be converted
         * @return the HashMap of Pair<K,V> elements
         */
        HashMap<K, V> hashMap = new HashMap<K, V>();
        for (Pair<K, V> item:
                arr) {
            hashMap.put(item.getKey(), item.getValue());
        }
        return hashMap;
    }

}

class GenericArray<T>{
    private List<T> arr;

    public <T> T getElement(int index){
        /**
         * Return element by index
         *
         * @param index index of element
         * @return T type element by index
         */
        return (T) arr.get(index);
    }

    public GenericArray(List<T> arr) {
        this.arr = arr;
    }

    public List<T> getArr() {
        return arr;
    }

    public void setArr(List<T> arr) {
        this.arr = arr;
    }
}

public class Tester {
    public static void main(String[] args) {

        /*
        Так я увидел схожесть по смыслу всех пунктов, решил не разбивать на файлы, 1
        пункт задания реализован в 5, newArrayList - фактически тот же конвертатор,
        зачем в 5 остальные методы остается только догадываться, т.к. задание обрезано.
        2 и 3 пункты - класс "GenericArray"
        4 реализован через класс "File"
        5 пункт - класс "Solution"
         */

        /*
        Получаю путь к каталогу с ДЗ
        создаю объект файла, которому в конструктор передаю путь
        Если по какой-то причине его нет, выдает ошибку отсутсвтия каталога.
        иначе получаем получаем массив строк, который с помощью метода newArrayList
        класса Solution конвертируем в список, этот список мы и записываем в класс
        GenericArray, ну и по его встроенному методу получения элемента через индекс
        выводим 5 первых элементов каталога
         */


        String path = System.getProperty("user.dir");
        path += "/src/";
        File catalog = new File(path);
        if (!catalog.exists()){
            System.out.println("Missing catalog!");
            return;
        }
        GenericArray generic = new GenericArray(Solution.newArrayList(catalog.list()));
        for (int i=0; i<5;i++){
            System.out.println(generic.getElement(i));
        }


        //Вывод в консоли:
        /*
        .idea
        Practice1
        Practice10
        Practice11
        Practice12
         */

    }
}
