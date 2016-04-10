package dicegame;

import javax.swing.*;

/**
 * Tehtävänanto: Tee noppapeli jollakin seuraavista olio-ohjelmointikielistä:
 * Java C# Python C++
 *
 * Pelin kulku: 1) Arvaa kahden nopan yhteenlaskettu silmäluku 2) Heitä noppaa
 * 3) Näytä kahden nopan yhteenlaskettu tulos ja ilmoita pelaajalle osuiko
 * arvaus oikein 4) Aloita uusi kierros tai lopeta ohjelma
 *
 * Tekstipohjainen peli riittää, mutta voit myös tehdä UI:n halutessasi.
 */

public class Main {

    public static void main(String[] args) {
        
        GUI UI = new GUI();  
        SwingUtilities.invokeLater(UI);
       
    }

}
