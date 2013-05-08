package Towary;

import java.io.*;
import java.util.Random;

/**
 * @author bartosz.kalinowski
 */
public class FileGenerator {

    public static void GenerateFile(String file, int amount) {
        try {
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            Random rand = new Random();
            for (int i=0; i<amount; i++) {
                out.write((new Towar(rand.nextDouble()*1000+1)).toString());
                out.newLine();
            }
            
            out.close();
        } catch (IOException ex) {
            System.err.println("Błąd zapisu: " + ex.getMessage());
        }
    }
}
