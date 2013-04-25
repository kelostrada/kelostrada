package WyszukiwanieWPlikach;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author s11027
 */
public class WyszukiwanieTest {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Test.java");
        Scanner in = new Scanner(file);
        int IfCounter;
        int WariantCounter = Szukacz.Szukaj(in, "wariant");

        StringBuilder sb = new StringBuilder();
        in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            sb.append(line);
            sb.append("\n");
        }

        IfCounter = Szukacz.SzukajIf(sb);

        System.out.println("Liczba instrukcji if: " + IfCounter);
        System.out.println("Liczba napisów: " + WariantCounter);

        Pattern p = Pattern.compile("/\\*.a.");
        Matcher matcher = p.matcher(" /* a */ a ");

        System.out.println(matcher.find());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        System.out.println(matcher.find());

    }
}
