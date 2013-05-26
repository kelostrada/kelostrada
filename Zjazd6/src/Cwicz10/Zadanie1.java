package Cwicz10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author bartosz.kalinowski
 */
public class Zadanie1 extends JFrame implements ActionListener {

    final JButton button;
    Color[] sequence = {Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED, Color.ORANGE, Color.BLACK};
    int currentColor = 0;

    public Zadanie1() {
        setLayout(new FlowLayout());
        button = new JButton("Zmień KOLOR!");
        button.addActionListener(this); // TEN obiekt będzie słuchaczem akcji
        button.setBackground(sequence[currentColor]);
        add(button);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (++currentColor >= sequence.length) {
            currentColor = 0;
        }
        button.setBackground(sequence[currentColor]);
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zadanie1();
            }
        });
    }
}
