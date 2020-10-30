package Practice3;

class Circle
{
    Circle(double r)
    {
        setR(r);
    }
    public double r = 0;

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    double getLength()
    {
        return 2*Math.PI*r;
    }

    double getSquare()
    {
        return Math.PI*r*r;
    }

    double getDiameter()
    {
        return 2*r;
    }

}

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        circle.setR(5);

        System.out.println(circle.getR());
        System.out.println(circle.getDiameter());
        System.out.println(circle.getLength());
        System.out.println(circle.getSquare());
    }
}
