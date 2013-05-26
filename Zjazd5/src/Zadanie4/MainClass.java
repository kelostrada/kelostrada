package Zadanie4;
import javax.swing.*;


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolTip;

public class MainClass {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Tooltip");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setToolTipText("<HtMl>Tooltip<br>Message");
    frame.add(panel, BorderLayout.CENTER);
    JButton button = new JButton("Hello, World") {
      public JToolTip createToolTip() {
        JToolTip tip = super.createToolTip();
        tip.setBackground(Color.WHITE);
        tip.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.RED));
        return tip;
      }
      public boolean contains(int x, int y) {
        if (x < 100) {
          setToolTipText("x < 100");
        } else {
          setToolTipText("<html><script type='text/javascript'>alert('asd'); document.getElementById('div').innerHTML = 'Fred Flinstone';</script><div id='diwek' style='font-size:25px;padding:10px;'>ABCD</div>W polu obok<br><font color='red'>wpisz kraj</font><br><font color='blue'>pochodzenia towaru</font>");
        }
        return super.contains(x, y);
      }
    };
     
    button.setToolTipText("Hello, World");
    frame.add(button, BorderLayout.NORTH);
    frame.setSize(300, 150);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
  