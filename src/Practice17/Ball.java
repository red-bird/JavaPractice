package Practice17;

import java.awt.*;

public class Ball
{
    public static final int RADIUS = 10;

    private int x, y; // координаты
    private int dx, dy; // изменение коодринат
    private Color color; // цвет (очевидно)
    private int speed; // скорость
    private int speedUpDelay = 100; // чем больше этот показатель, тем слабее разгоняется мячик
    private int delay = 0; // изначальное значение

    public Ball(Color c, int x, int y)
    {
        color = c;
        this.x = x;
        this.y = y;
        // задаем изначальное направление случайно + устанавливаем начальную скорость
        dx = (Math.random() < .5)?1:-1;
        dy = (Math.random() < .5)?1:-1;
        speed = 7;
    }

    public void move()
    {
        delay = (delay+1)%speedUpDelay;
        if(delay == 0)
            speed++;
        x+=(int)(getUnitDX()*speed);
        y+=(int)(getUnitDY()*speed);
    }

    public Point getLocation()
    {
        return new Point(x,y);
    }

    private double getUnitDX()
    {
        return ((double)dx/(double)(Math.sqrt(dx*dx + dy*dy)));
    }

    private double getUnitDY()
    {
        return ((double)dy/(double)(Math.sqrt(dx*dx + dy*dy)));
    }

    public void bounceSide()
    {
        dx = -dx;
        dy = (int)(Math.random()*8)-4;
        move();
        move();
    }

    public void bounceTop()
    {
        dy = -dy;
        move();
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
    }
}