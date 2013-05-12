package Zadanie2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author bartosz.kalinowski
 */

public class Layouty extends JFrame {
    
    public Layouty(Character c) {
        JPanel panel = new JPanel();
        LayoutManager lm = null;
        switch (c) {
            case 'A':
                lm = new BorderLayout();
                break;
            case 'B':
                lm = new FlowLayout();
                break;
            case 'C':
                lm = new FlowLayout(FlowLayout.LEFT);
                break;
            case 'D':
                lm = new FlowLayout(FlowLayout.RIGHT);
                break;
            case 'E':
                lm = new GridLayout(1, 0);
                break;
            case 'F':
                lm = new GridLayout(0, 1);
                break;
            case 'G':
                lm = new GridLayout(3, 2);
                break;
        }
        panel.setLayout(lm);
        panel.add(new JButton("Przycisk 1"), "West");
        panel.add(new JButton("P 2"), "North");
        panel.add(new JButton("Większy przycisk numer 3"), "East");
        panel.add(new JButton("Przycisk 4"), "South");
        panel.add(new JButton("P5"), "Center");
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        String temp = JOptionPane.showInputDialog(null, "Podaj Rodzaj layoutu (A-G)", "Input", JOptionPane.QUESTION_MESSAGE);
        
        Character opcja = temp.charAt(0);
        Layouty layout = new Layouty(opcja);
    }
}
