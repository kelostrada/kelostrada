package Zadanie4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author bartosz.kalinowski
 */

class Kolko extends JLabel {
    
    String circle;
    String tooltip;
    
    public Kolko(String circle, String tooltip) {
        this.circle = circle;
        this.tooltip = tooltip;
        this.setText(circle);
    }
    
}

class Ramka extends JPanel {
    
    String button;
    String circle;
    String tooltip;
    int textFieldSize;
    
    public Ramka(String button, String circle, String tooltip, int textFieldSize) {
        this.button = button;
        this.circle = circle;
        this.tooltip = tooltip;
        this.textFieldSize = textFieldSize;
        
        this.setPreferredSize(new Dimension(600,100));
        
        setLayout(new BorderLayout());
        
        JPanel left = new JPanel();
        left.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JButton b = new JButton(button);
        left.add(b);
        JTextField tf = new JTextField(textFieldSize);
        tf.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));
        left.add(tf);
        
        this.add(left, "West");
        
        JPanel right = new JPanel();
        right.setLayout(new FlowLayout(FlowLayout.RIGHT));
        right.add(new Kolko(circle, tooltip));
        
        this.add(right, "East");
        
    }
}


public class Test {
    public static void main(String[] args) {
        JFrame form = new JFrame();
        Ramka ramka = new Ramka("Kraj", "Jak wpisać kraj?","W polu obok<br><font color='red'>wpisz kraj</font><br><font color='blue'>pochodzenia towaru</font>",20);

        form.add(ramka);
        
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.pack();
    }
}
