package Practice26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class City{
    private String name;
    private String country;

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

public class CityTester {
    static Map<String, ArrayList<String>> map = new HashMap<>();

    public static void main(String[] args) {
        //Делаем список для удобства
        List<City> lst = List.of(
                new City("Moscow", "Russia"),
                new City("Cheboksary", "Russia"),
                new City("Tokio", "Japan"),
                new City("Krakow","Poland"),
                new City("Warsaw","Poland"),
                new City("London", "UK"),
                new City("York", "UK"),
                new City("Edinburgh", "UK")
        );
        //Пихаем в ассоциативный массив, если там нет ключа, то создаем массив, а потом пихаем
        for (City c : lst){
            if (!map.containsKey(c.getCountry())){
                map.put(c.getCountry(), new ArrayList<>());
            }
            map.get(c.getCountry()).add(c.getName());
        }
        //Почему бы еще раз не заюзать streamAPI, зачем? а почему бы и нет
        map.entrySet().stream().forEach(System.out::println);

        //Вывод
        //Japan=[Tokio]
        //UK=[London, York, Edinburgh]
        //Poland=[Krakow, Warsaw]
        //Russia=[Moscow, Cheboksary]
    }
}
