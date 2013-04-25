package Odwracanko;

/**
 * @author bartosz.kalinowski
 */
public class ReverseTest {
    
  public ReverseTest() {
    Reversible[] r = new Reversible[] {
        new ReversibleString("Kot"), 
        new ReversibleDouble(2.0), 
        new ReversibleDouble(3), 
        new ReversibleString("Pies"), 
        new ReversibleString("Ala ma kota i psa"), 
        new ReversibleDouble(10),
    };
    
    System.out.println("Normalne:");
    // wypisanie inicjalnych wartości z tablicy r
    // odwrócenie wartości z tablicy r
    for (Reversible rr : r) {
        System.out.println(rr);
    }
    
    
    System.out.println("Odwrócone:");
    // wypisanie odwróconych wartości z tablicy r
    for (Reversible rr:r) {
        rr.reverse();
        System.out.println(rr);
    }
    
    
    System.out.println("Przywrócone i zmienione:");
    // przywrócenie oryginalnych wartości (ponowne odwrócenie) i
    // i wypisanie ich z następującymi zmianami: 
    // - dla Stringów dodanie przed napisem napisu "Tekst"
    // - dla liczb dodanie do liczby wartości 10
    
    for (Reversible rr:r) {
        rr.reverse();
        if (rr instanceof ReversibleString) {
            System.out.println("Tekst " + rr);
        }
        if (rr instanceof ReversibleDouble) {
            System.out.println(((ReversibleDouble)rr).getValue()+10);
        }
    }
    

  }

  public static void main(String[] args) {
     new ReverseTest();
  }

}

/*
 * Wynik:
Normalne:
Kot
2.0
3.0
Pies
Ala ma kota i psa
10.0
Odwrócone:
toK
0.5
0.3333333333333333
seiP
asp i atok am alA
0.1
Przywrócone i zmienione:
Tekst Kot
12.0
13.0
Tekst Pies
Tekst Ala ma kota i psa
20.0
 */