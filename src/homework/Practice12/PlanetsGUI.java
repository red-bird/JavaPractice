package homework.Practice12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class PlanetsGUI {
    JFrame frame;
    JPanel panel;
    JLabel info, answer;
    JComboBox selector;
    Dimension dim = new Dimension(100,100);
    PlanetsGUI()
    {
        frame = new JFrame();
        frame.setTitle("PlanetsGUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,360);


        panel = new JPanel();
        panel.setLayout(new GridLayout(3,0));
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        frame.add(panel);

        info = new JLabel("Выберите планету");
        info.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(info);

        selector = new JComboBox(Planets.values());
        selector.setSize(100,20);
        panel.add(selector);

        answer = new JLabel();
        panel.add(answer);

        selector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Planets tmp = (Planets)selector.getSelectedItem();
                answer.setText("Гравитация на " + tmp.name() + " равна " + tmp.getGravity());
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PlanetsGUI();
    }
}
