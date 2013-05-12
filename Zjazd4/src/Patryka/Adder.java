package Patryka;

import java.io.*;
import java.util.*;

public class Adder extends Thread{
    private int count = 1;
    public Adder(){
    }
    public void run(){
        try{
            FileInputStream fis = new FileInputStream(new File("C:\\Temp\\Towary.txt"));
            Scanner scn = new Scanner(fis);
            while(scn.hasNext()){
                scn.next();
                String str = scn.next();
                Main.add(str);
                if(count%200 == 0){
                    System.out.println("Dodano " + count);
                }
                count++;
            }
            Main.add("-1");
        }catch(FileNotFoundException ex){
        }
        System.out.println("Czas :" + (new Date().getTime() - Main.czas));
    }
}