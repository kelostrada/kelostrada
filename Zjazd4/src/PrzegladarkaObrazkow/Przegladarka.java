package PrzegladarkaObrazkow;

/**
 * @author Kelu
 */
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.*;

class ImagePanel extends JPanel {

    Image img;
    boolean loaded = false; // czy obrazek został załadowany?

    public ImagePanel(String imgFileName) {
        loadImage(imgFileName);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        if (img != null && loaded) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.drawString("Błąd odczytu obrazka", 10, getHeight() - 10);
        }
    }

    void loadImage(String imgFileName) {
        img = Toolkit.getDefaultToolkit().getImage(imgFileName);
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 1);
        try {
            mt.waitForID(1);
        } catch (InterruptedException exc) {
        }
        int w = img.getWidth(this); // szerokość obrazka
        int h = img.getHeight(this); // wysokość obrazka

        if (w != -1 && w != 0 && h != -1 && h != 0) {
            loaded = true;
            setPreferredSize(new Dimension(w, h));
        } else {
            setPreferredSize(new Dimension(300, 200));
            loaded = false;
        }
        repaint();

    }
}

class FinalPanel extends JPanel {

    private int size;

    public FinalPanel(int size) {
        this.size = size;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setPreferredSize(new Dimension(size * 13, size * 13));
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, size));
        drawBorders(getWidth(), getHeight(), g);
        drawCenteredString("Koniec prezentacji", getWidth(), getHeight(), g);
    }

    private void drawCenteredString(String s, int w, int h, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }

    private void drawBorders(int w, int h, Graphics g) {
        int x = 10;
        int y = 15;
        g.drawLine(x, x, x, h - x);
        g.drawLine(x, x, w - x, x);
        g.drawLine(w - x, x, w - x, h - x);
        g.drawLine(x, h - x, w - x, h - x);
        g.drawLine(y, y, y, h - y);
        g.drawLine(y, y, w - y, y);
        g.drawLine(w - y, y, w - y, h - y);
        g.drawLine(y, h - y, w - y, h - y);
        g.drawLine(y, y, w - y, h-y);
    }
}

public class Przegladarka extends JFrame {

    ImagePanel p;

    public Przegladarka() {
        this("");
    }

    public Przegladarka(String fname) {
        p = new ImagePanel(fname);
        add(p);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void loadImage(String imgFileName) {
        p.loadImage(imgFileName);
        pack();
        setLocationRelativeTo(null);
    }

    public void loadFinalPanel(int size) {

        remove(p);
        FinalPanel f = new FinalPanel(size);
        add(f);
        f.paintComponent(getGraphics());

        pack();
        setLocationRelativeTo(null);
    }
    static final String[] EXTENSIONS = new String[]{
        "gif", "jpg", "GIF", "JPG"
    };
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public static void main(String args[]) {

        String temp = JOptionPane.showInputDialog(null, "Podaj katalog z obrazkami\nczas wyświetlania jednego obrazka (w sek.)\nrozmiar pisma dla napisu 'Koniec Prezentacji'", "Input", JOptionPane.QUESTION_MESSAGE);
        String[] parametry = null;
        if (temp == null || (parametry = temp.split(" ")).length != 3) {
            System.err.println("Błędna ilość parametrów");
            System.exit(-1);
        }

        File path = new File(parametry[0]);
        int time = 0;
        int size = 0;
        try {
            time = Integer.parseInt(parametry[1]);
            size = Integer.parseInt(parametry[2]);
        } catch (NumberFormatException ex) {
            System.err.println("Niepoprawne parametry.");
            System.exit(-2);
        }

        Przegladarka p = new Przegladarka();
        p.setTitle("Przeglądarka Obrazków");

        if (path.isDirectory()) {
            for (final File f : path.listFiles(IMAGE_FILTER)) {
                p.loadImage(f.getPath());
                try {
                    Thread.sleep(time * 1000);
                } catch (InterruptedException ex) {
                }
            }
        }

        p.loadFinalPanel(size);

    }
}
