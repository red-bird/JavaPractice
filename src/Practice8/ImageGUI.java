package Practice8;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ImageGUI extends JFrame {
    public ImageGUI(String path){
        setTitle("ImageGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize();
        setSize(dim.width-50, dim.height);
        setResizable(true);
        setVisible(true);

        Graphics grph;
        Image img;

        img = new ImageIcon(path).getImage();

        grph = getGraphics();
        while(true) {
            grph.drawImage(img, (dim.width-img.getWidth(null))/2, (dim.height-img.getHeight(null))/2, null);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter road to img");
        String path = new String();
        Scanner sc = new Scanner(System.in);
        path = sc.nextLine();
        new ImageGUI(path);
    }
}

