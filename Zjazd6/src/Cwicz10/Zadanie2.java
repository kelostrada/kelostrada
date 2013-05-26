package Cwicz10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author bartosz.kalinowski
 */
public class Zadanie2 extends JFrame {

    final JButton button1, button2;
    final JPanel panel;
    
    void checkSize() {
        int width = getSize().width;
        int height = getSize().height;
        
        if (width < getPreferredSize().width) {
            width = getPreferredSize().width;
        }
        
        if (height < getPreferredSize().height) {
            height = getPreferredSize().height;
        }
        
        setSize(width,height);
    }

    public Zadanie2() {
        button1 = new JButton("Przycisk 1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize2D() + 1));
                checkSize();
            }
        });
        button2 = new JButton("Przycisk 2");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize2D() + 1));
                checkSize();
            }
        });
        setLayout(new FlowLayout());
        
        panel = new JPanel();

        panel.add(button1);
        panel.add(button2);
        
        add(panel);
        
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Zadanie2();
            }
        });
    }
}
