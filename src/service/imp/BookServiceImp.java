package service.imp;

import dao.imp.BookDaoImp;
import database.DataBase;
import models.Book;
import models.Library;
import service.BookService;

import java.util.List;

public class BookServiceImp implements BookService {
private final BookDaoImp bookDaoImp;

    public BookServiceImp(BookDaoImp bookDaoImp) {
        this.bookDaoImp = bookDaoImp;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for(Library i : DataBase.libraries){
            if(i.getId().equals(libraryId)){
                return bookDaoImp.saveBook(libraryId,book);
            }
        }
        System.out.println("Library with this id not found");
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for(Library i : DataBase.libraries){
            if(i.getId().equals(libraryId)){
                return bookDaoImp.getAllBooks(libraryId);
            }
        }
        System.out.println("Library with this id not found");
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for(Library i : DataBase.libraries) {
            if (i.getId().equals(libraryId)) {
                return bookDaoImp.getBookById(libraryId,bookId);
            }
        }

        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for(Library i : DataBase.libraries) {
            if (i.getId().equals(libraryId)) {
                bookDaoImp.deleteBook(libraryId, bookId);
                return "successfully deleted";
            }
        }
        return "successfully deleted";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        boolean isTrue = true;
        for(Library i : DataBase.libraries) {
            if (i.getId().equals(libraryId)) {
                isTrue = false;
                bookDaoImp.clearBooksByLibraryId(libraryId);
                System.out.println("successfully cleared");
            }
        }
        if(isTrue){
            System.out.println("Library with this id not found");
        }
    }
}
