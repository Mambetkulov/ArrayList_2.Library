package dao.imp;

import dao.BookDao;
import database.DataBase;
import models.Book;
import models.Library;

import java.util.List;

public class BookDaoImp implements BookDao {

    @Override
    public Book saveBook(Long libraryId, Book book) {
        DataBase.books.add(book);
        for(Library i : DataBase.libraries){
            if(i.getId().equals(libraryId)){
                i.setBooks(book);
                break;
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for(Library i : DataBase.libraries){
            if(i.getId().equals(libraryId)){
                return i.getBooks();
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for(Library i : DataBase.libraries) {
            if (i.getId().equals(libraryId)) {
               for(Book j : i.getBooks()){
                   if(j.getId().equals(bookId)){
                       return j;
                   }
               }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for(Library i : DataBase.libraries) {
            if (i.getId().equals(libraryId)) {
                for(Book j : i.getBooks()){
                    if(j.getId().equals(bookId)){
                        i.getBooks().remove(j);
                        break;
                    }
                }
            }
        }

        return "successfully deleted";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
         for(Library i : DataBase.libraries){
             if(i.getId().equals(libraryId)){
                 i.getBooks().clear();
                 System.out.println("successfully cleared");
                 break;
             }
         }

    }
}
