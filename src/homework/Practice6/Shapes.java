package homework.Practice6;

abstract class Shape
{
    int dimension;
}

interface IMoveable
{
    public void Move(int x, int y);
}

class Circle extends Shape
{
    int r;
}

class Rectangle extends Shape
{
    int a,b;
}

class MoveablePoint implements IMoveable
{
    int speed, x, y;
    @Override
    public void Move(int x, int y)
    {
        this.x+=x;
        this.y+=y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}

class MoveableRectangle extends Rectangle implements IMoveable
{
    @Override
    public void Move(int x, int y)
    {
        a+=x;
        b+=y;
    }
}

class MoveableRectangle2
{
    MoveablePoint x,y;
    boolean checkSpeed(MoveablePoint x, MoveablePoint y)
    {
        return x.speed==y.speed;
    }
}



public class Shapes {
}
