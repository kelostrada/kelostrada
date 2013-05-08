package PrzegladarkaObrazkow;

/**
 * @author Kelu
 */
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class ImagePanel extends JPanel {

    Image img;
    boolean loaded = false; // czy obrazek został załadowany?

    public ImagePanel(String imgFileName) {
        loadImage(imgFileName);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null && loaded) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.drawString("Błąd odczytu obrazka", 10, getHeight() - 10);
        }
    }

    public void loadImage(String imgFileName) {
        this.repaint();
        img = Toolkit.getDefaultToolkit().getImage(imgFileName);
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 1);
        try {
            mt.waitForID(1);
        } catch (InterruptedException exc) {
        }
        int w = img.getWidth(this); // szerokość obrazka
        int h = img.getHeight(this); // wysokość obrazka

        loaded = true;
        setPreferredSize(new Dimension(w, h));

    }
}

public class Przegladarka extends JFrame {

    ImagePanel p;

    public Przegladarka(String fname) {
        p = new ImagePanel(fname);
        add(p);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void loadImage(String imgFileName) {
        p.loadImage(imgFileName);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        
        String temp = JOptionPane.showInputDialog(null,"Podaj katalog z obrazkami\nczas wyświetlania jednego obrazka (w sek.)\nrozmiar pisma dla napisu 'Koniec Prezentacji'","Input", JOptionPane.QUESTION_MESSAGE);
        String[] parametry = null;
        if (temp == null || (parametry = temp.split(" ")).length != 3) {
            System.err.println("Błędna ilość parametrów");
            System.exit(-1);
        }
        
        String path = parametry[0];
        try {
        int time = Integer.parseInt(parametry[1]);
        int size = Integer.parseInt(parametry[2]);
        } catch (NumberFormatException ex) {
            System.err.println("Niepoprawne parametry.");
            System.exit(-2);
        }
        
        
        Przegladarka p = new Przegladarka("beach.jpg");

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Przegladarka.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.loadImage("temp.jpg");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Przegladarka.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.loadImage("beach.jpg");

        }
    }
}
