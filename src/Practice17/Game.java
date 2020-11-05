package Practice17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class GamePanel extends JPanel implements ActionListener {
    final int radius = 50;
    Random ran;
    GamePanel(){
        ran = new Random();
    }

    public int getPosition(int min, int max) {
        return ran.nextInt(max - min) + min;
    }

    @Override
    public void print(Graphics g) {
        super.print(g);

        g.drawOval(getPosition(100,980), getPosition(100,620), radius, radius);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

public class Game {
    final int GAME_SPEED = 1000;
    Game(){
        JFrame game = new JFrame();
        game.setTitle("Aim Train");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(1080,720);
        game.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setLayout(new GridLayout(3,0));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));

        gamePanel.print();
        game.add(gamePanel);

        Timer timer = new Timer(GAME_SPEED, new TargetCreator(this));
        timer.start();

        game.setVisible(true);
    }


}
