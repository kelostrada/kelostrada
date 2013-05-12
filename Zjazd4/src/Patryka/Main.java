package Patryka;

import java.util.*;

public class Main{
    public static Vector<Double> v;
    public static long czas;
    public static void main(String[] args)throws InterruptedException{
        Main.v = new Vector();
        Adder a = new Adder();
        Summer s = new Summer();
        Main.czas = new Date().getTime();
        a.start();
        s.start();
         
    }
    public static synchronized void add(String str){
        v.add(new Double(str));
    }
    public static synchronized Double get(int i){
        return v.elementAt(i);
    }
}