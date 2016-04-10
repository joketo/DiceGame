
package dicegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DiceButtonListener implements ActionListener {

    private JLabel info;
    private JTextField theQuess;
    private JLabel sumField;
    private JComboBox numberOfSides;
    private JLabel rightOrWrong;
    private JLabel firstDiceImage;
    private JLabel secondDiceImage;
    private int chosenDiceType;

    public DiceButtonListener(JComboBox sides, JTextField theQuess,
            JLabel sumField, JLabel rightOrWrong,
            JLabel info, JLabel firstDice, JLabel secondDice) {
        this.numberOfSides = sides;
        this.theQuess = theQuess;
        this.sumField = sumField;
        this.rightOrWrong = rightOrWrong;
        this.info = info;
        this.firstDiceImage = firstDice;
        this.secondDiceImage = secondDice;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        chosenDiceType = Integer.parseInt((this.numberOfSides.getSelectedItem().toString()));
        Dice firstDice = new Dice(chosenDiceType);
        Dice secondDice = new Dice(chosenDiceType);
        int first = firstDice.throwTheDice();
        int second = secondDice.throwTheDice();

        int sum = first + second;
        if (this.theQuess.getText().isEmpty()) {
            rightOrWrong.setText("Arvaa jotain lukua!");
        } else {
            try {
                if (sum == Integer.parseInt(this.theQuess.getText())) {
                    rightOrWrong.setText("Oikein!");
                    rightOrWrong.setForeground(java.awt.Color.green);
                } else {
                    rightOrWrong.setText("Väärin!");
                    rightOrWrong.setForeground(java.awt.Color.red);
                }
                info.setText("Voit kokeilla uudestaan tai lopettaa.");
                sumField.setText("Arvasit "+ theQuess.getText() +", summa oli " + sum);
                firstDiceImage.setIcon(createIcon(Integer.toString(first)));
                secondDiceImage.setIcon(createIcon(Integer.toString(second)));
            } catch (Exception e) {
                info.setText("Virhe: Kirjoita vain numeroita!");
            }
        }
    }

    private ImageIcon createIcon(String number) {
        java.net.URL imgURL = getClass().getResource("images/" + Integer.toString(this.chosenDiceType) + number + ".png");
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + "images/" + Integer.toString(this.chosenDiceType) + number + ".png");
            return null;
        }
    }

}
