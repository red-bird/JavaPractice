package homework.Practice2;

import java.util.ArrayList;
import java.util.Scanner;

class Dog
{
    String name;
    int age;
    void setName(String name)
    {
        this.name = name;
    }
    void setAge(int age)
    {
        this.age = age;
    }
    String getName()
    {
        return name;
    }
    int getAge()
    {
        return age;
    }
    Dog(String name, int age)
    {
        setAge(age);
        setName(name);
    }
    int getHumanAge()
    {
        return getAge()*7;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class DogKennel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();

        ArrayList dogs = new ArrayList(n);

        for (int i = 0; i < n; ++i)
        {
            String name;
            int age;
            name = in.next();
            age = in.nextInt();
            Dog dog = new Dog(name, age);
            dogs.add(dog);
        }

        for (int i = 0; i < n; ++i)
        {
            System.out.println(dogs.get(i).toString());
        }
    }
}
