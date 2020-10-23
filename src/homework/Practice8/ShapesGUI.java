package homework.Practice8;

import javax.swing.*;
import java.awt.*;

abstract class Shape extends JComponent{
    private int x, y, width, height;

    protected int getColor(){
        return (int)(Math.random()*256);
    }
}
    class Circle extends Shape{
    private  int x, y, width, height;

    public Circle(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height =height;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        Color color = new Color(getColor(),getColor(),getColor());
        g2d.setPaint(color);
        g2d.fillOval(x,y,width,height);
    }
}

    class Square extends Shape{
    private  int x, y, width, height;

    public Square(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height =height;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        Color color = new Color(getColor(),getColor(),getColor());
        g2d.setPaint(color);
        g2d.fillRect(x,y,width,height);
    }
}


public class ShapesGUI extends JFrame
{
    public ShapesGUI()
    {
        setTitle("ShapesGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        Circle circle;
        Square square;

        Toolkit tools = Toolkit.getDefaultToolkit();
        Dimension dimension = getToolkit().getScreenSize();

        int width = dimension.width;
        int height = dimension.height;
        int cols = 5;
        int rows = 4;
        setSize(width, height);

        setSize(width + 15, height + 40);

        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                switch((int)(Math.random()*2)){
                    case 0:
                        circle = new Circle(i*width/cols,j*height/rows, width/cols - 4,height/rows - 4);
                        add(circle);
                        break;
                    case 1:
                        square = new Square(i*width/cols,j*height/rows, width/cols - 4,height/rows - 4);
                        add(square);
                        break;
                }
                setVisible(true);
            }
        }
        setResizable(false);
    }

    public static void main(String[] args) {
        new ShapesGUI();
    }
}
