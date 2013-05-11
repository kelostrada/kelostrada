package Przekatna;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author bartosz.kalinowski
 */

class FinalPanel extends JPanel {

    public FinalPanel() {
        setPreferredSize(new Dimension(300,300));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        drawBorders(getWidth(), getHeight(), g);
    }

    private void drawBorders(int w, int h, Graphics g) {
        int x = 0;
        g.drawLine(x, x, w, h);
    }
}

public class Przekatna extends JFrame {
    
    public Przekatna() {
        super("Przekatna");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void loadFinalPanel() {
        
        panel = new FinalPanel();
        add(panel);
        panel.paintComponent(getGraphics());

        pack();
        setLocationRelativeTo(null);
    }
    
    FinalPanel panel;
    
    public static void main(String args[]) {
        Przekatna p = new Przekatna();
        p.loadFinalPanel();
    }
    
}
