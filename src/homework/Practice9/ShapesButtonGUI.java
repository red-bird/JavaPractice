package homework.Practice9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Shape extends JComponent{
    private int x, y, width, height;

    protected int getColor(){
        return (int)(Math.random()*256);
    }
}
class Circle extends Shape {
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

class Square extends Shape {
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

public class ShapesButtonGUI implements ActionListener{
    Circle circle;
    Square square;
//    private JFrame frame;
//    private JPanel panel;
        public ShapesButtonGUI(int cols, int rows)
        {
            JFrame frame = new JFrame();

            JButton button = new JButton("Random");
            button.addActionListener(this);

            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
            panel.add(button);

            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle(("ShapesButtonGUI"));
            frame.pack();
            frame.setVisible(true);
        }
//    }

    public static void main(String[] args) {
        new ShapesButtonGUI(4,4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1200,700);
        panel.setSize(1200,700);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(5,5));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle(("ShapesButtonGUI"));
//        frame.pack();
        frame.setVisible(true);
        int x = 5;
        for (int i = 0; i < x*x; i++)
            switch((int)(Math.random()*2)){
            case 0:
                circle = new Circle(300/x,300/x, 300/x,300/x);
                panel.add(circle);
                break;
                case 1:
                    square = new Square(300/x,300/x, 300/x,300/x);
                    panel.add(square);
                    break;
        }
    }
}
