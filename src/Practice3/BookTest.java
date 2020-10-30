package Practice3;
class Book
{
    String author, name;
    int year, amountOfPages;
    void setAuthor(String author){this.author=author;}
    void setName(String name){this.name=name;}
    void setYear(int year){this.year=year;}
    void setAmountOfPages(int amount){this.amountOfPages = amount;}
    String getAuthor(){return author;}
    String getName(){return name;}
    int getYear(){return year;}
    int getAmoutOfPages(){return amountOfPages;}

    Book(String author, String name, int year)
    {
        setAuthor(author);
        setName(name);
        setYear(year);
    }

    Book(String author, String name, int year, int amountOfPages)
    {
        this(author, name, year);
        setAmountOfPages(amountOfPages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", amountOfPages=" + amountOfPages +
                '}';
    }
}
public class BookTest {
    public static void main(String[] args)
    {
        Book book = new Book("Mark Twein", "Tom Soyer", 2020, 345);
        System.out.println(book);
    }
}

