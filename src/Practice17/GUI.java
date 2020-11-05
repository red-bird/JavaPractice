package Practice17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        JFrame menu;
        JPanel panel;
        JLabel info;
        JButton button;

        // set menu
        menu = new JFrame();
        menu.setTitle("Aim Train Menu");
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setSize(640,360);
        menu.setResizable(false);

        // set panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,0));
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        menu.add(panel);

        //set label
        info = new JLabel("Испытайте свою скорость!");
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setFont(new Font("Roboto", Font.BOLD, 32));
        panel.add(info);

        //set button
        button = new JButton("Начать!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                new Game();
            }
        });
        panel.add(button);

        menu.setVisible(true);
    }
}
