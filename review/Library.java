import Book;
public class Library {
    private final List<Book> books;
    public Library (){}
        Library(List<Book> b) {
            this.books = b;
        }
        public List<Book> getList() {
            return books; 
        }
    }
