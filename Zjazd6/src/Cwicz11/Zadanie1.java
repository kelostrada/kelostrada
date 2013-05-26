import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

class MousePlay extends JFrame implements MouseInputListener {

  private Container cp = getContentPane();
  private int currIndex = 0;              // do tworzenia kolejnych znaków
  private int diffX =0, diffY =0;         // używane przy wleczeniu
  private boolean isDragged;              // czy wleczenie

  // Ramki dla etykiet
  Border normal = BorderFactory.createLineBorder(Color.black),
        pointed = BorderFactory.createLineBorder(Color.red, 2),
        dragged = BorderFactory.createLineBorder(Color.blue, 4);

  public MousePlay() {

   cp.setLayout(null); // bez rozkładu!

   cp.addMouseListener(new MouseAdapter() {
     public void mouseReleased(MouseEvent e) {
       if (e.isMetaDown()) {                           // prawy klawisz  
         if (e.isControlDown()) removeAllComponents(); // z Ctrl - usunięcie wszystkich
         else  setVisibility();                        // bez - ukrycie
       }
       else addLabel(e.getX(), e.getY());              // lewe klawisz - dodanie etykiety
     }
   });
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setSize(300, 300);
   setLocationRelativeTo(null);
   setVisible(true);
   
  }

  // Utworzenie i dodanie etykiety w miejscu kursora myszki (x, y)
  private void addLabel(int x, int y) {
     JLabel l = new JLabel("" + (char) ('A' + currIndex++));
     l.setBounds(x, y, 50, 50);
     l.setBorder(normal);
     l.setFont(new Font("Dialog", Font.BOLD, 24));
     l.setHorizontalAlignment(JLabel.CENTER);
     l.setVerticalAlignment(JLabel.CENTER);
     l.addMouseListener(this);
     l.addMouseMotionListener(this);
     cp.add(l);
  }

  // zmiana widoczności komponentów w panelu
  private void setVisibility() {
    for (Component comp : cp.getComponents() ) comp.setVisible(!comp.isVisible());
  }

  // usunięcie wszystkich komponentów
  private void removeAllComponents() {
    cp.removeAll();
    cp.repaint();
  }

  // Metody obsługujące zdarzenia myszki dla etykiet

  // Przy wejściu kursora w obszar etykiety - zmiana ramki, ale tylko wtedy
  // gdy nie wleczemy jakiejś innej etykiety

  public void mouseEntered(MouseEvent e) {
    if (isDragged) return;
    ((JComponent) e.getSource()).setBorder(pointed);
  }

  // Przywrócenie ramki z uwagą j.w.
  public void mouseExited(MouseEvent e) {
    if (isDragged) return;
    ((JComponent) e.getSource()).setBorder(normal);
  }


  public void mousePressed(MouseEvent e) {
   isDragged = true; // być może zaczynamy wleczenie
   ((JComponent) e.getSource()).setBorder(dragged); // ramka dla wleczenia
   diffX = e.getX(); // w jakiej odległości kursor od górnego rogu komponentu
   diffY = e.getY(); // - potrzebne do korygowania zmian lokalizacji
  }                  //   przy wleczeniu

  public void mouseReleased(MouseEvent e) {
    isDragged = false;           // ew. koniec wleczenia
    if (e.isControlDown()) {     // usunięcie etykiety, jeśli wciśnięto Ctrl
      cp.remove(e.getComponent());
      cp.repaint();
      return;
    }
    ((JComponent) e.getSource()).setBorder(pointed);
  }

  // wleczenie polega na zmianie położenia
  public void mouseDragged(MouseEvent e) {
    Component c = e.getComponent();
    // nowe położenie musimy skorygować w zależności od tego
    // w jakim miejscu schwyciliśmy etykietę (diffX, diffY)
    c.setLocation(c.getX() + e.getX() - diffX, c.getY() + e.getY() - diffY);
  }

  public void mouseClicked(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}

  public static void main(String[] a) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MousePlay();
      }
    });
  }

}