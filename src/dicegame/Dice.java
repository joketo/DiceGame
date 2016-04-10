package dicegame;

import java.util.Random;

public class Dice {

    private Random random;
    private int numberOfSides;

    public Dice(int sides) {
        this.random = new Random();
        this.numberOfSides = sides;

    }

    public int throwTheDice() {
        int luku = random.nextInt(this.numberOfSides); // value between 0 - numberOfSides
        return luku + 1;
    }
}
