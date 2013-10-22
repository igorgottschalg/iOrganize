/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iorganize;

import Forms.jMain;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.*;

/**
 *
 * @author Igor Gottschalg
 */
public class Main {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                jMain main = new jMain();
                main.show();
                SubstanceLookAndFeel.setSkin(new RavenSkin());
            }
        });
    }
}
