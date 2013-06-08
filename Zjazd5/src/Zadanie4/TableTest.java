/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Zadanie4;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import layout.TableLayout;

/**
 *
 * @author Kelu
 */
public class TableTest {
    
    public static void main(String[] args) {
    // Create a frame
        Frame frame = new Frame("Example of TableLayout");
        
        double borderOut = 5;
        double szerokoscGuzika = 100;
        double szerokoscTekstu = 300;
        double szerokoscLabela = 80;
        double wysokoscRamki = 60;
        
        double size[][] = {{borderOut,szerokoscGuzika,szerokoscTekstu,szerokoscLabela,borderOut},{borderOut,wysokoscRamki,borderOut}};
        
        frame.setLayout(new TableLayout(size));
        
        frame.add(new JButton("Button A"), "1,1,l,c");
        frame.add(new JTextField(30), "2,1,l,c");
        frame.add(new RoundLabel("kraj",30, Color.yellow),"3,1,r,c");
        
        
        // Dodawanie panelu, po to żeby border był, głupie ale co tu lepszego wymyśleć =.=
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.blue));
        frame.add(panel,"0,0,4,2");
        frame.pack();
        
        // Allow user to close the window to terminate the program
        frame.addWindowListener
            (new WindowAdapter()
                {
                    public void windowClosing (WindowEvent e)
                    {
                        System.exit (0);
                    }
                }
            );

        // Show frame
        frame.show();
    }
    
    

}
