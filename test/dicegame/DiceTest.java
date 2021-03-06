package dicegame;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {

    public DiceTest() {

    }

    /**
     * Test of throwTheDice method, of class Dice.
     */
    
    @Test
    public void testThrowTheDiceWithFourSides() {
        System.out.println("throwTheDice");
        Dice instance = new Dice(4);
        int result = instance.throwTheDice();
        boolean expResult = isInTheRange(4, result);
        assertTrue("kun nopassa on 4 tahoa, yhden nopan heittotuloksen pitäisi olla välillä 1-4", expResult);
    }
    
    @Test
    public void testThrowTheDiceWithSixSides() {
        System.out.println("throwTheDice");
        Dice instance = new Dice(6);
        int result = instance.throwTheDice();
        boolean expResult = isInTheRange(6, result);
        assertTrue("kun nopassa on 6 tahoa, yhden nopan heittotuloksen pitäisi olla välillä 1-6", expResult);
    }
    
    @Test
    public void testThrowTheDiceWithEightSides() {
        System.out.println("throwTheDice");
        Dice instance = new Dice(8);
        int result = instance.throwTheDice();
        boolean expResult = isInTheRange(8, result);
        assertTrue("kun nopassa on 8 tahoa, yhden nopan heittotuloksen pitäisi olla välillä 1-8", expResult);
    }
    
    @Test
    public void testThrowTheDiceWithTwelveSides() {
        System.out.println("throwTheDice");
        Dice instance = new Dice(12);
        int result = instance.throwTheDice();
        boolean expResult = isInTheRange(12, result);
        assertTrue("kun nopassa on 12 tahoa, yhden nopan heittotuloksen pitäisi olla välillä 1-12", expResult);
    }

    private boolean isInTheRange(int maxValue, int value) {
        for (int i = 1; i <= maxValue; i++) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

}
