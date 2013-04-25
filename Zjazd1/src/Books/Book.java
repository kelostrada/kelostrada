package Books;

/**
 * @author s11027
 */
class Book {
    
    private String Autor;
    private String Tytuł;
    private Bookshelf Półka = null;
    
    public Book(String autor, String tytuł) {
        Autor = autor;
        Tytuł = tytuł;
    }

    public Bookshelf getPółka() {
        return Półka;
    }
    
    public void setPółka(Bookshelf p1) {
        Półka = p1;
    }

    @Override
    public String toString() {
        return Autor + " " + Tytuł;
    }
    
}
