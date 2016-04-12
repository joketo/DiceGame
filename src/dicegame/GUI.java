
package dicegame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;


public class GUI implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Vesivärinoppapeli");
        frame.setPreferredSize(new Dimension(620, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JPanel banner = new JPanel(new GridLayout(1,1));
        ImageIcon bannerPicture = createImageIcon("images/noppia.png");
        banner.add(new JLabel(bannerPicture));
        
        JButton play = new JButton("Heitä noppia");
        JTextField quess = new JTextField();
        JLabel sum = new JLabel("",JLabel.CENTER);
        JLabel rightOrWrong = new JLabel("", JLabel.CENTER);
        JButton quit = new JButton("Lopeta");
        JLabel info = new JLabel(" ", JLabel.CENTER);

        String[] numberOfSides = {"4", "6", "8", "12"};
        JComboBox numberOfDiceSides = new JComboBox(numberOfSides);
        numberOfDiceSides.setSelectedIndex(1);

        ImageIcon firstDiceDefault = createImageIcon("images/tyhjanoppa.png");
        ImageIcon secondDiceDefault = createImageIcon("images/tyhjanoppa.png");
        JLabel firstDiceImage = new JLabel(firstDiceDefault, JLabel.CENTER);
        JLabel secondDiceImage = new JLabel(secondDiceDefault, JLabel.CENTER);

        JPanel setValues = new JPanel(new GridLayout(2, 2));
        setValues.add(new JLabel("Nopan tahkojen lkm: "));
        setValues.add(numberOfDiceSides);
        setValues.add(new JLabel("Arvaa noppien yhteenlaskettu silmäluku:"));
        setValues.add(quess);

        JPanel result = new JPanel(new GridLayout(3, 1));
        result.add(rightOrWrong);
        result.add(sum);
        result.add(info);

        JPanel Dices = new JPanel(new GridLayout(1, 2));
        Dices.add(firstDiceImage);
        Dices.add(secondDiceImage);

        JPanel buttons = new JPanel(new GridLayout(1, 2));
        buttons.add(play);
        buttons.add(quit);

        play.addActionListener(new DiceButtonListener(numberOfDiceSides, quess,
                sum, rightOrWrong, info, firstDiceImage, secondDiceImage));
        quit.addActionListener(new QuitButtonListener());
        
        container.add(banner);
        container.add(setValues);
        container.add(Dices);
        container.add(result);
        container.add(buttons);


    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public JFrame getFrame() {
        return frame;
    }

}
