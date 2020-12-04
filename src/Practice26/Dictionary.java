package Practice26;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Dictionary {
    public static void main(String[] args) {
        Map<String, String> dict = Map.of(
                "Синицин", "Игорь",
                "Гончаров", "Сергей",
                "Бондарчук", "Володя",
                "Свиблов", "Иван",
                "Боголюбов", "Сергей",
                "Чехарин", "Игорь",
                "Хрусталев", "Радион",
                "Чертов", "Кирилл",
                "Суворов", "Дмитрий",
                "Кузневцов", "Борис"
        );

        //Меняю ключи и значения местами, потому что могу
        Map<String, String> swapped = new HashMap<>();
        for (Map.Entry e : dict.entrySet()){
            swapped.putIfAbsent((String)e.getValue(), (String)e.getKey());
        }

        //Очищаю от совпадений через streamAPI и помещаю в другой ассциативный массив
        swapped = swapped.entrySet().stream().distinct().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        //Кто бы мог подумать, еще раз меняю ключи и значения местами
        Map<String, String> map = new HashMap<>();
        for (Map.Entry e : swapped.entrySet()){
            map.putIfAbsent((String)e.getValue(), (String)e.getKey());
        }

        //Ну и вывод
        System.out.println("Map:\n" + (map));
        //Вывод
        //Map:
        //{Чертов=Кирилл, Хрусталев=Радион, Бондарчук=Володя, Гончаров=Сергей, Синицин=Игорь, Суворов=Дмитрий, Кузневцов=Борис, Свиблов=Иван}
    }
}
