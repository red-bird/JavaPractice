package homework.Practice8;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnimationGUI extends JFrame {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dim = toolkit.getScreenSize();
    int width = dim.width-50, height = dim.height;
    JPanel pnl = new JPanel();
    public AnimationGUI()
    {
        setTitle("AnimationGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
        setVisible(true);

        Graphics g;
        Image img;
        ArrayList<Image> images = new ArrayList<>();
        String path = AnimationGUI.class.getResource("").getPath();
        for (int i = 0; i <= 5; i++)
            images.add(new ImageIcon( path+ "gif/" + i + ".gif").getImage());

        while(true)
        {
            for (int i = 0; i < 5; i++)
            {
                img = images.get(i);
                g = getGraphics();
                g.drawImage(img,0,0, width, height,null);
                timeDelay();
            }
        }
    }

    private void timeDelay()
    {
        try
        {
            Thread.sleep(50);
        }
        catch (InterruptedException e){}
    }

    public static void main(String[]args)
    {
        new AnimationGUI();
    }
}
