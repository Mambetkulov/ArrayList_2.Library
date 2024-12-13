package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    Long id ;
    String name;
    String address;
    List<Book> books;
    List<Reader> readers;


    public Library(Long id, String name, String address, List<Book> books, List<Reader> readers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books.add(books);
    }

    public List<Reader> getReaders() {
        return readers;
    }


    public void setReaders(Reader reader) {
        this.readers.add(reader);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +

                '}';
    }




}
