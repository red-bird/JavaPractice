package Practice17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Target extends JComponent {
    Game gamePanel;
    int x, y;

    Target(Game gamePanel, int x, int y){
        this.gamePanel = gamePanel;
        this.x = x;
        this.y = y;
    }
}

public class TargetCreator implements ActionListener {
    Game gamePanel;


    TargetCreator(Game gamePanel){
        this.gamePanel = gamePanel;
//        ran = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Target target = new Target(gamePanel, getPosition(100,980), getPosition(100,620));
    }
}
