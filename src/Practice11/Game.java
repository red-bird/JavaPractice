package Practice11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game implements ActionListener {
    int counter, value;
    JFrame frame;
    JLabel label, answer;
    JTextField textField;
    public Game(int value)
    {
        this.value = value;
        counter = 3;
        frame = new JFrame();
        JButton button = new JButton("В этот раз мне повезет!");
        button.addActionListener(this);

        label = new JLabel("Попыток осталось: 3");
        answer = new JLabel("Угадай число от 0 до 20");
        textField = new JTextField(15);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,0));
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));

        label.setHorizontalAlignment(SwingConstants.CENTER);
        answer.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label);
        panel.add(answer);
        panel.add(textField);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Games");
        frame.setSize(640,360);
//        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter--;
        if (counter == 0)
        {
            JOptionPane.showMessageDialog(null, "Game over");
            frame.dispose();
        }
        label.setText("Попыток осталось: " + counter);
        int input = Integer.parseInt(textField.getText());
        if (input == value)
        {
            JOptionPane.showMessageDialog(null, "Вы выиграли! Это было число " + value);
            frame.dispose();
        }
        else if (input > value)
        {
            answer.setText("Оно меньше    В прошлый раз ты выбрал " + input);
            textField.setText("");
            return;
        }
        else
        {
            answer.setText("Оно больше    В прошлый раз ты выбрал " + input);
            textField.setText("");
            return;
        }
    }

    public static void main(String[] args) {
        int value = new Random().nextInt(21);
        new Game(value);
    }
}
