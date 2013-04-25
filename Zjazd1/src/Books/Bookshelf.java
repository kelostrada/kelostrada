package Books;

import java.util.ArrayList;

/**
 * @author s11027
 */
class Bookshelf {
    
    private int Rozmiar;
    private String Nazwa;
    private ArrayList<Book> Books;

    Bookshelf(String nazwa, int rozmiar) {
        Nazwa = nazwa;
        Rozmiar = rozmiar;
        Books = new ArrayList<>(rozmiar);
    }

    void insert(Book b1) throws Exception {
        if (b1.getPółka() != null) {
            throw new Exception("Nie mogę wstawić książki na półkę (Półka "+Nazwa+") - jest już na półce: Półka "+b1.getPółka().getNazwa());
        } else {
            if (Books.size() < Rozmiar) {
                Books.add(b1);
                b1.setPółka(this);
            } else {
                throw new Exception("Nie mogę wstawić książki na półkę (Półka "+Nazwa+") - brak miejsca");
            }
            
        }
    }

    ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>(Books);
//        for (Book b : Books) {
//            books.add(b);
//        }
        return books;
    }

    void remove(Book b) throws Exception {
        if (b.getPółka() == null) {
            throw new Exception("Nie mogę zdjąć książki z półki (Półka "+Nazwa+") - nie jest na tej półce");
        } else {
            if (b.getPółka().equals(this)) {
                Books.remove(b);
                b.setPółka(null);
            } else {
                throw new Exception("Nie mogę zdjąć książki z półki (Półka "+Nazwa+") - nie jest na tej półce. Jest na półce " + b.getPółka());
            }
        }
    }

    private String getNazwa() {
        return Nazwa;
    }

    @Override
    public String toString() {
        return "Półka " + Nazwa;
    }
}