package Practice2;

class Shape
{
    int length, width, amountOfLines;
    {
        length = 10;
        width = 10;
        amountOfLines = 3;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "length=" + length +
                ", width=" + width +
                ", amountOfLines=" + amountOfLines +
                '}';
    }
}


public class task1 {

    static class Tester
    {
        public static void test(Shape obj)
        {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        Shape obj = new Shape();
        Tester.test(obj);
    }

}
