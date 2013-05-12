package Zadanie3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author bartosz.kalinowski
 */

public class Komponenty extends JFrame {
    
    private void initialize() {
        JPanel p = new JPanel();
        BorderLayout b = new BorderLayout();
        p.setLayout(b);
        
        JPanel guzikiNorth = new JPanel();
        guzikiNorth.setLayout(new GridLayout(1,1));
        
        JPanel guzikiLewe = new JPanel();
        guzikiLewe.setLayout(new FlowLayout(FlowLayout.LEFT));
        guzikiLewe.add(new JButton("A1"));
        guzikiLewe.add(new JButton("A2"));
        guzikiLewe.add(new JButton("A3"));
        
        
        JPanel guzikiPrawe = new JPanel();
        guzikiPrawe.setLayout(new FlowLayout(FlowLayout.RIGHT));
        guzikiPrawe.add(new JButton("B1"));
        guzikiPrawe.add(new JButton("B2"));
        guzikiPrawe.add(new JButton("B3"));
        
        guzikiNorth.add(guzikiLewe);
        guzikiNorth.add(guzikiPrawe);
        
        p.add(guzikiNorth, "North");
        
        JPanel tekst = new JPanel();
        tekst.setLayout(new BorderLayout());
        JScrollPane scrollingArea = new JScrollPane(new JTextArea(20,40));
        tekst.add(scrollingArea);
        
        p.add(tekst, "Center");
        
        //JPanel panelSouth = new JPanel();
        //panelSouth.setLayout(new GridLayout(1,1));
        
        JPanel przechowywaczKlawiatury = new JPanel();
        przechowywaczKlawiatury.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JPanel klawiaturaNumeryczna = new JPanel();
        klawiaturaNumeryczna.setLayout(new GridLayout(3,3));
        for (int i=0;i<9;i++) {
            klawiaturaNumeryczna.add(new JButton(String.valueOf(i)));
        }
        
        przechowywaczKlawiatury.add(klawiaturaNumeryczna);
        
        JPanel textFields = new JPanel();
        textFields.setLayout(new GridLayout(3,0,5,5));
        Box panelSouth = Box.createHorizontalBox(); 
        
        for(int i=1;i<=3;i++) {
            JTextField tf = new JTextField("To jest JTextField...   ");
            tf.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));
            textFields.add(tf);
        }
        
        
        panelSouth.add(przechowywaczKlawiatury);
        panelSouth.add(Box.createGlue());
        panelSouth.add(textFields);
        panelSouth.add(Box.createGlue());
        
        p.add(panelSouth,"South");
        
        
        add(p);
        
        setMinimumSize(new Dimension(400,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public Komponenty() {
        initialize();
        
    }
    
    public static void main(String[] args) {
        Komponenty k = new Komponenty();
    }
}
