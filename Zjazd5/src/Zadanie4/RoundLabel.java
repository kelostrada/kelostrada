package Zadanie4;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RoundLabel extends JLabel {

    String label;
    int r;

    public RoundLabel(String label, int r, Color c) {
        super("",null,CENTER);

        setFont(Font.decode("ARIAL-11"));


        // These statements enlarge the label so that it
        // becomes a circle rather than an oval.
        //Dimension size = getPreferredSize();
        //size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(new Dimension(2*r,2*r));
        
        setBounds(0, 0, 2 * r, 2 * r);

        setText("<html><div style='width: " + 2 * r + "pt; '><center><font color='blue'>Jak <br/>wpisać</font><br/><font color='red'>" + label + "?</font></center></div></html>");
        setToolTipText("<html>W polu obok<br><strong><font color='red'>wpisz "+label+"</font></strong><br><font color='blue'>pochodzenia towaru</font>");
        setBackground(c);
    }

    // Paint the round background and label.
    protected void paintComponent(Graphics g) {

        g.setColor(getBackground());
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        // This call will paint the label and the focus rectangle.
        super.paintComponent(g);
    }

    // Paint the border of the button using a simple stroke.
    protected void paintBorder(Graphics g) {
        g.setColor(Color.blue);
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }
    // Hit detection.
    Shape shape;

    public boolean contains(int x, int y) {
        // If the button has changed size, make a new shape object.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    @Override
    public JToolTip createToolTip() {
        JToolTip tip = super.createToolTip();
        tip.setBackground(Color.WHITE);
        tip.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
        return tip;
    }

    // Test routine.
    public static void main(String[] args) {
        // Create a button with the label "Jackpot".
        JLabel button = new RoundLabel("kraj", 30, Color.yellow);


        // Create a frame in which to show the button.
        JFrame frame = new JFrame();
        //frame.getContentPane().setBackground(Color.yellow);
        frame.setLayout(null);
        
        
        
        frame.add(button);
//        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(580, 140);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


    }
}