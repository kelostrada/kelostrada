package Inkrementor;

import static Inkrementor.Incrementer.*;
/**
 * @author bartosz.kalinowski
 */

public class Test {
  
  public static void main(String[] args) {
      
    
    // najprostsza iteracja - krok = 1
    for(int k : in(1, 10)) {
          System.out.print(k + " ");
      }
    System.out.println();
    
    // Podany krok
    for(int k : in(1, 10).by(2)) {
          System.out.print(k + " ");
      }
    System.out.println();
  
    // Można w odwrotną stronę - tu domyślnie krok = -1
    for(int k : in(10, 1)) System.out.print(k + " ");
    System.out.println();

    // Ale można zakres formułować od min do max, a podany krok będzie 
    // decydował o kierunku iteracji
    for(int k : in(1, 10).by(-1)) System.out.print(k + " ");
    System.out.println();
  
    // W trakcie iteracji można zmieniac krok
    Incrementer inc;
    for (int i : inc = in(1,10) ) {
      if (i == 4) inc.by(2);
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : inc = in(1,10) ) {
      if (i == 8) inc.by(-2);
      System.out.print(i + " ");
    }
    System.out.println();
    for(int k : inc = in(10, 1)) {
      if (k == 5) {
            inc.by(1);
        }
      System.out.print(k + " ");
    }
/*
*/
  }



}