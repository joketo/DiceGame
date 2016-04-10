
package dicegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuitButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
}
