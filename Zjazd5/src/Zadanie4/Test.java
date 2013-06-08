package Zadanie4;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import layout.TableLayout;

/**
 * @author bartosz.kalinowski
 */

class Ramka extends JPanel {
    
    String label;
    String circle;
    int textFieldSize;
    
    public Ramka(String label, String circle, int textFieldSize, int mnemonic, Icon icon) {
        this.label = label;
        this.circle = circle;
        this.textFieldSize = textFieldSize;
        
        double borderOut = 5;
        double odstep = 2;
        double szerokoscLewego = 70;
        double szerokoscTekstu = 300;
        double szerokoscLabela = 60;
        double wysokoscRamki = 60;
        
        double size[][] = {{borderOut,szerokoscLewego,odstep,szerokoscTekstu,odstep,szerokoscLabela,borderOut},{borderOut,wysokoscRamki,borderOut}};
        
        setLayout(new TableLayout(size));
       
        JTextField tf = new JTextField(textFieldSize);
        tf.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.orange));
        
        JPanel labelek = new JPanel();
        labelek.setLayout(new BorderLayout());
        labelek.setBackground(Color.decode("#ffffcb"));
        labelek.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JLabel b = new JLabel(label,icon, SwingConstants.RIGHT);
        b.setDisplayedMnemonic(mnemonic);
        b.setLabelFor(tf);
        b.setHorizontalTextPosition(SwingConstants.LEFT);
        
        labelek.add(b,"East");
        
        add(labelek, "1,1,f,c");
        add(tf, "3,1,l,c");
        add(new RoundLabel(circle,30, Color.yellow),"5,1,r,c");
        
        
        // Dodawanie panelu, po to żeby border był, głupie ale co tu lepszego wymyśleć =.=
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.blue));
        add(panel,"0,0,6,2");
        
        /*
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        JPanel kolko = new JPanel();
        kolko.setLayout(new FlowLayout(FlowLayout.RIGHT));
        RoundLabel rl = new RoundLabel(circle, 30, Color.yellow);
        kolko.add(rl);
        
        Box tekst = Box.createVerticalBox();
        JTextField tf = new JTextField(textFieldSize);
        tf.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));
        tf.setAlignmentY(CENTER_ALIGNMENT);
        tekst.add(tf);
        
        this.add(Box.createRigidArea(new Dimension(6,0)));
        this.add(new JButton(button));
        this.add(Box.createRigidArea(new Dimension(3,0)));
        
        this.add(tekst);
       
        this.add(kolko);
        */
    }
}


public class Test {
    public static void main(String[] args) {
        JFrame form = new JFrame();
        Ramka ramkaKraj = new Ramka("Kraj", "kraj",10, KeyEvent.VK_K, new ImageIcon("red.gif"));
        Ramka ramkaMiasto = new Ramka("Miasto", "miasto", 25, KeyEvent.VK_M, new ImageIcon("red.gif"));
        Ramka ramkaAdres = new Ramka("Adres", "adres", 30, KeyEvent.VK_A, new ImageIcon("green.gif"));
        Ramka ramkaTelefon = new Ramka("Telefon", "telefon", 12, KeyEvent.VK_T, new ImageIcon("red.gif"));
        Ramka ramkaFax = new Ramka("Fax", "fax", 12, KeyEvent.VK_F, new ImageIcon("green.gif"));
        
        double odstep = 3;
        double wysokosc = 70;
        
        double[][] size = {{odstep,TableLayout.FILL,odstep},{odstep,wysokosc,odstep,wysokosc,odstep,wysokosc,odstep,wysokosc,odstep,wysokosc,odstep}};
        
        form.setLayout(new TableLayout(size));
        
        form.add(ramkaKraj,"1,1");
        form.add(ramkaMiasto,"1,3");
        form.add(ramkaAdres,"1,5");
        form.add(ramkaTelefon,"1,7");
        form.add(ramkaFax,"1,9");
        
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.pack();
    }
}
