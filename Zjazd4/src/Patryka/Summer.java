package Patryka;

import java.util.*;

public class Summer extends Thread{
    private Main m;
    private int count = 1;
    private Double sum;
    public Summer(){
        sum = new Double (0.0);
    }
    public void run(){
        Double d = new Double(0);
        while(d.intValue() != -1 && d!=null){
            if( Main.v.size() > count){
                d = Main.get(count);
                if(d != null){
                    sum += d;
                }
                if(count%100 == 0){
                    System.out.println("zsumowano " + count);
                }
                count++;
            }else{
                this.yield();
                //System.out.println("Yelding");
            }
        }
        System.out.println("Suma to " + sum);
        System.out.println("Czas: " + (new Date().getTime()-Main.czas) );
    }
}