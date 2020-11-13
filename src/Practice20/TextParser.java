package Practice20;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class TextParser {
    public static List<Map.Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap)
    {
        Set<Entry<String, Integer>> entries = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        path += "/src/Practice20/";
        File input = new File(path + "input.txt");
        File output = new File(path + "output.txt");
        if (!input.exists()){
            System.out.println("Missing input file");
            return;
        }
        if (!output.exists()){
            output.createNewFile();
        }
        else{
            output.delete();
        }

        //подключаем "считыватель"
        FileReader fileReader = new FileReader(input);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Создаем буффер
        String buff;

        //подключаем "записыватель"
        FileWriter fileWriter = new FileWriter(output, true);
        fileWriter.flush();
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        //Достаем каждую строчку, меняем символы и записываем в новый файл
        //Также записываем в словарь количество каждого слова, используя фильтры
        while (bufferedReader.ready()){
            buff = bufferedReader.readLine();
            for (String piece : buff.split(" ")){
                if ((buff.length() < 1) || (!Character.isLetter(buff.charAt(0)))) {continue;}
                if (wordMap.containsKey(piece)){
                    wordMap.put(piece, (wordMap.get(piece)+1));
                }
                else
                    wordMap.put(piece, 1);
            }
            buff = buff.replace(' ', '#');
            bufferedWriter.write(buff.replace(' ', '#'));
            bufferedWriter.newLine();
//            System.out.println(buff); вот тут прикола не понял, у меня почему-то в output не записывается сколько-то строчек,
// хотя если эту строчку разкомментировать будет видно, что у меня все работает правильно и до конца, мб какие-то ограничения на сам файл в моей ОС, хз
        }

        //Переводим словарь в список и сортируем по убыванию
        List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
        int counter = 0;
        //Собственно выводим топ 10 слов, если убрать счетчик, то будет список всех слов.
        for (Map.Entry<String, Integer> entry : list)
        {
            if (counter == 10){break;};
            if (entry.getValue() > 1)
            {
                ++counter;
                System.out.println('\'' + entry.getKey() + '\'' + " => " + entry.getValue());
            }
        }
        bufferedReader.close();
        fileReader.close();
    }
}
