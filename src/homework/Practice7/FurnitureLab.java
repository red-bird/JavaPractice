package homework.Practice7;

import java.util.ArrayList;

interface IPriceable
{
    int getPrice();
}
abstract class Furniture implements IPriceable
{
    int price, weight;
    String name, factory;
    void setPrice(int cost){this.price=cost;}
    void setWeight(int Weight){this.weight=weight;}
    void setName(String name){this.name=name;}
    void setFactory(String factory){this.factory=factory;}
    int getWeight(){return weight;}
    String getName(){return name;}
    String getFactory(){return factory;}
    abstract String GetAd();

    @Override
    public int getPrice() {
        return price;
    }
}

class Table extends Furniture
{
    int size;
    void setSize(int size){this.size = size;}
    int getSize(){return size;}

    {
        price = 5000;
        weight = 20;
        name = "OakLike";
        factory = "Zaporozhsky table factory";
        size = 40;
    }


    @Override
    public String toString() {
        return "Table{" +
                "price=" + price +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", factory='" + factory + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    String GetAd() {
        return "This table can endure the hit of sledgehammer!";
    }
}

class Sofa extends Furniture
{
    int humanCapacity;
    void setHumanCapacity(int capacity){this.humanCapacity = capacity;}
    int getHumanCapacity(){return getHumanCapacity();}
    {
        price = 20000;
        weight = 50;
        name = "ultraLight";
        factory = "Ivanovsky sofa factory";
        humanCapacity = 6;
    }

    @Override
    public String toString() {
        return "Sofa{" +
                "price=" + price +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", factory='" + factory + '\'' +
                ", humanCapacity=" + humanCapacity +
                '}';
    }

    @Override
    String GetAd() {
        return "The most important thing in the party!";
    }
}

class FurnitureShop
{
    static Furniture BuyTable()
    {
        return new Table();
    }
    static Furniture BuySofa()
    {
        return new Sofa();
    }
}

class Person
{
    private ArrayList cart = new ArrayList();
    void addToCart(Furniture tmp)
    {
        cart.add(tmp);
    }
    ArrayList getCart()
    {
        return cart;
    }
}
public class FurnitureLab {
    public static void main(String[] args)
    {
        Person bob = new Person();
        bob.addToCart(FurnitureShop.BuySofa());
        bob.addToCart(FurnitureShop.BuyTable());
        bob.addToCart(FurnitureShop.BuySofa());
        for (Object item:
             bob.getCart()) {
            System.out.println(item);
        }
    }
}
