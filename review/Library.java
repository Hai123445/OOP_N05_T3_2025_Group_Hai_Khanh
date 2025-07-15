<<<<<<< HEAD
import java.util.List;
public class Library {
    private final List<Book> books;
    public Library(){}
    Library(List<Book> books){
        this.books = books;
    }
    public List<Book> getBooks(){
        return books;}
    }

=======
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
>>>>>>> f32b3e812fd7d723d181d01be0b8a20dcf35791c
