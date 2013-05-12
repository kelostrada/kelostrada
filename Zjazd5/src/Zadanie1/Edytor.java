package Zadanie1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author bartosz.kalinowski
 */
class TextPanel extends JPanel {
    
    JTextArea textArea = new JTextArea();
    
    public TextPanel() {
        setPreferredSize(new Dimension(300, 400));
        JScrollPane scrollingArea = new JScrollPane(textArea);
        setLayout(new BorderLayout());
        add(scrollingArea, BorderLayout.CENTER);
        textArea.setBackground(Color.BLUE);
        textArea.setFont(new Font("Dialog", Font.ITALIC | Font.BOLD, 14));
        textArea.setForeground(Color.YELLOW);
        
    }
}

public class Edytor extends JFrame {
    
    TextPanel panel;
    
    public Edytor() {
        super("Edytor");
        //setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new TextPanel();
        add(panel);
        pack();
    }
    
    public static void main(String args[]) {
        Edytor e = new Edytor();        
    }
}
