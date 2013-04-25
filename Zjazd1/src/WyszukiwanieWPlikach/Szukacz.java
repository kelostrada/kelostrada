package WyszukiwanieWPlikach;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author s11027
 */
public class Szukacz {

    public static int Szukaj(Scanner in, String s) {
        int Counter = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            while (line.indexOf(s) != -1) {
                Counter++;
                int index = line.indexOf(s);
                line = line.substring(index + 1);
            }
        }
        return Counter;
    }

    public static int SzukajIf(StringBuilder sb) {
        int Counter = 0;

        ArrayList<Przedzial> przedzialy = new ArrayList<>();
        
        String str = sb.toString();
        
        str = str.replaceAll("if([ ]*)\n", "if$1 ");
        str = str.replaceAll("if([ ]*)\\(([\\d\\s=\\-\\<\\>\\*\\(\\)]*)\n", "if$1($2 ");
        System.out.println(str);
        
        sb = new StringBuilder(str);

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '/') {
                if (sb.charAt(i + 1) == '/') {
                    int end = sb.indexOf("\n", i);
                    przedzialy.add(new Przedzial(i, end));
                }
                if (sb.charAt(i + 1) == '*') {
                    int end = sb.indexOf("*/", i);
                    if (end == -1) {
                        end = sb.length();
                    }
                    przedzialy.add(new Przedzial(i, end));
                }
            }
        }
        
        Pattern p = Pattern.compile("[\\s\\{ ]{0,1}if[\\s ]*\\(.+\\)");
        Matcher matcher = p.matcher(str);

        int przedzial = 0;

        while (matcher.find()) {

            boolean matched = true;
            for (Przedzial prz : przedzialy) {
                if (prz.getStart() <= matcher.start() && prz.getEnd() >= matcher.end()) {
                    matcher.region(prz.getEnd(), matcher.regionEnd());
                    matched = false;
                    break;
                }
            }
            if (matched) {
                if (Counter == 8) {
                    Counter++;
                }
                else {
                    Counter++;
                }
                matcher = matcher.region(matcher.start() + 2, matcher.regionEnd());
            }
        }
        

        return Counter;
    }
}
