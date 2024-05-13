/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expotec1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class NewClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String texto = "<html><div style='transform: rotate(90deg); " +
                           "white-space: nowrap;'>Hora: 16:50</div></html>";
            JLabel label = new JLabel(texto);

            frame.getContentPane().add(label);
            frame.pack();
            frame.setVisible(true);
        });
    }

}
