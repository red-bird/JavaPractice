package Practice16;

import java.util.ArrayDeque;

class DrunkGame{
    private ArrayDeque<Integer> firstDeck = new ArrayDeque<Integer>(5);
    private ArrayDeque<Integer> secondDeck = new ArrayDeque<Integer>(5);
    private int round = 0;

    private int[] getDeck(String deck){
        int intDeck = Integer.parseInt(deck);
        int[] tmp = new int[5];
        for (int i = 4; i >= 0; --i){
            tmp[i] = intDeck%10;
            intDeck/=10;
        }
        return tmp;
    }

    public void setFirstDeck(String deck){
        int[] tmp = getDeck(deck);
        for (int i = 0; i < 5; ++i){
            firstDeck.add(tmp[i]);
        }
    }

    public void setSecondDeck(String deck){
        int[] tmp = getDeck(deck);
        for (int i = 0; i < 5; ++i){
            secondDeck.add(tmp[i]);
        }
    }

    public void start(){
        while (firstDeck.size() != 0 && secondDeck.size() != 0){
            ++round;
            int first = firstDeck.pollFirst();
            int second = secondDeck.pollFirst();
            if (first == 0 && second == 9)
                firstDeck.add(second);
            else if (second == 0 && first == 9)
                secondDeck.add(first);
            else if (first > second)
                firstDeck.add(second);
            else secondDeck.add(first);
        }
        if (firstDeck.size() == 0)
            System.out.println("second " + round);
        else
            System.out.println("first " + round);
    }

}

public class DrunkGameTester {
    public static void main(String[] args) {
        DrunkGame game = new DrunkGame();
        game.setFirstDeck("13579");
        game.setSecondDeck("24680");
        game.start();

        game.setFirstDeck("17426");
        game.setSecondDeck("35890");
        game.start();

        game.setFirstDeck("57123");
        game.setSecondDeck("48906");
        game.start();
    }
}
