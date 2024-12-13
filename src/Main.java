import dao.imp.BookDaoImp;
import dao.imp.LibraryDaoImp;
import dao.imp.ReaderDaoImp;
import database.Generate;
import enumP.Gender;
import enumP.Genre;
import models.Book;
import models.Library;
import models.Reader;
import service.imp.BookServiceImp;
import service.imp.LibraryServiceImp;
import service.imp.ReaderServiceImp;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   static Scanner text = new Scanner(System.in);
   static Scanner num = new Scanner(System.in);
  static LibraryDaoImp libraryDaoImp = new LibraryDaoImp();
  static LibraryServiceImp libraryServiceImp = new LibraryServiceImp(libraryDaoImp);
  static ReaderDaoImp readerDaoImp = new ReaderDaoImp();
  static ReaderServiceImp readerServiceImp = new ReaderServiceImp(readerDaoImp);
  static BookDaoImp bookDaoImp = new BookDaoImp();
  static BookServiceImp bookServiceImp = new BookServiceImp(bookDaoImp);
  static Genre[] genres = {Genre.ACTION,Genre.DETECTIVE,Genre.DRAMA,Genre.FICTION,Genre.ROMANCE,Genre.NON_FICTION,Genre.HORROR};

    public static void main(String[] args) {

        boolean isTrue = true;

        while(isTrue){
            System.out.println("""
                    \n
                    READER - PRESS 1 ;
                    LIBRARY - PRESS 2 ;
                    BOOK - PRESS 3 ;
                    EXIT - PRESS 4 ;
                    \n
                    """);


            try {
                int choice = new Scanner(System.in).nextInt();
                switch (choice) {
                    case 1:{
                         readerPanel(readerServiceImp);
                         break;
                    }
                    case 2:{
                        libraryPanel();
                        break;
                    }
                    case 3:{
                        bookPanel();
                        break;
                    }
                    case 4:{
                        isTrue = false;
                        break;
                    }
                    default:{
                        System.out.println("invalid command");
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("Type only numbers");
            }
        }

    }




    public static void readerPanel (ReaderServiceImp readerServiceImp){

        boolean isTrue = true;
        while (isTrue){
            System.out.println("""
                    \n
                    SAVE READER PRESS 1 :
                    GET ALL READERS PRESS 2 :
                    GET READER BY ID PRESS 3 :
                    UPDATE PRESS 4 :
                    ASSIGN READER TO LIBRARY 5 :
                    BACK PRESS 6 :
                    \n
                    """);

            try {
                int choice = new Scanner(System.in).nextInt();
                switch (choice){
                    case 1 : {

                            readerServiceImp.saveReader(blankeReader());

                        break;
                    }
                    case 2 : {
                        System.out.println( readerServiceImp.getAllReaders());
                        break;
                    }
                    case 3 : {
                        boolean turnOff = false;
                        System.out.println("Write id");
                        do {
                            try {

                                Reader read = readerServiceImp.getReaderById(new Scanner(System.in).nextLong());
                                System.out.println(read == null ? "Reader with this id not found" : read);
                            }catch (InputMismatchException e){
                                turnOff = true;
                                System.out.println("only numbers");
                            }

                        }while(turnOff);
                        break;
                    }

                    case 4 : {
                        boolean cycle = false;

                        do {
                            try {

                                System.out.println("write reader id");
                                Reader reader = readerServiceImp.updateReader(new Scanner(System.in).nextLong(),blankeReader());
                                System.out.println(reader == null ? "Reader with this id not found" : reader);
                            } catch (InputMismatchException e) {
                                System.out.println("only numbers");
                                cycle = true;
                            }
                        }while(cycle);

                        break;
                    }
                    case 5 : {
                        boolean cycle = false;

                        do {
                            try {
                                System.out.println("write reader id and then library id");

                                readerServiceImp.assignReaderToLibrary(new Scanner(System.in).nextLong(),new Scanner(System.in).nextLong());
                            } catch (InputMismatchException e) {
                                System.out.println("only numbers");
                                cycle = true;
                            }
                        }while(cycle);
                        break;

                    }
                    case 6:{
                        isTrue = false;
                        break;
                    }
                    default:{
                        System.out.println("invalid command");
                    }

                }

            }catch (InputMismatchException e){
                System.out.println("Type only numbers");
            }
        }
    }






    public static void libraryPanel (){
        boolean isTrue = true;
        while(isTrue){
            System.out.println("""
                    \n
                    ADD LIBRARY - PRESS 1
                    GET ALL LIBRARY - PRESS 2
                    GET LIBRARY BY ID - PRESS 3
                    UPDATE LIBRARY BY ID - PRESS 4
                    DELETE LIBRARY BY ID - PRESS 5
                    BACK - PRESS 6
                    \n
                    """);

            try {
                int choice = new Scanner(System.in).nextInt();
                switch (choice){
                    case 1 : {

                        libraryServiceImp.saveLibrary(blankeLibrary());
                        break;
                    }
                    case 2 : {
                        System.out.println(libraryServiceImp.getAllLibraries());

                        break;
                    }
                    case 3 : {
                        boolean turnOff = false;
                        System.out.println("Write id");
                        do {
                            try {

                                Library library = libraryServiceImp.getLibraryById(new Scanner(System.in).nextLong());
                                System.out.println(library == null ? "library with this id not found" : library);
                            }catch (InputMismatchException e){
                                turnOff = true;
                                System.out.println("only numbers");
                            }

                        }while(turnOff);
                        break;
                    }

                    case 4 : {
                        boolean cycle = false;

                        do {
                            try {

                                System.out.println("write library id");
                                Library library = libraryServiceImp.updateLibrary(new Scanner(System.in).nextLong(),blankeLibrary());
                                System.out.println(library == null ? "Library with this id not found " : library);
                            } catch (InputMismatchException e) {
                                System.out.println("only numbers");
                                cycle = true;
                            }
                        }while(cycle);

                        break;
                    }
                    case 5 : {
                        boolean cycle = false;

                        do {
                            try {
                                System.out.println("write library id ");

                                System.out.println( libraryServiceImp.deleteLibrary(new Scanner(System.in).nextLong()));

                            } catch (InputMismatchException e) {
                                System.out.println("only numbers");
                                cycle = true;
                            }
                        }while(cycle);
                        break;

                    }
                    case 6:{
                        isTrue = false;
                        break;
                    }
                    default:{
                        System.out.println("invalid command");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Type only numbers");
            }

        }

    }


    public static void bookPanel() {
        boolean isTrue = true;
        while (isTrue){
            System.out.println("""
                    \n
                    SAVE BOOK - PRESS 1
                    GET ALL BOOKS - PRESS 2
                    GET BOOK BY ID - PRESS 3
                    DELETE BY ID - PRESS 4
                    CLEAR ALL BOOKS BY LIBRARY ID - PRESS 5
                    BACK - 6
                    \n
                    """);

            try {
                int choice = new Scanner(System.in).nextInt();
                switch (choice){
                    case 1 : {
                        try{
                            System.out.println("write library id ");
                            bookServiceImp.saveBook(new Scanner(System.in).nextLong(),blankeBook());
                        } catch (Exception e) {
                            System.out.println("only numbers");
                        }

                        break;
                    }
                    case 2 : {
                        try{
                            System.out.println("write Library id ");
                            System.out.println( bookServiceImp.getAllBooks(new Scanner(System.in).nextLong()) );


                        } catch (Exception e) {
                            System.out.println("only numbers");
                        }

                        break;
                    }
                    case 3 : {
                        boolean turnOff = false;
                        System.out.println("Write library id and then book id" );
                        do {
                            try {

                                Book book = bookServiceImp.getBookById(new Scanner(System.in).nextLong(),new Scanner(System.in).nextLong());
                                System.out.println(book == null ? "Library with this id not found" : book);
                            }catch (InputMismatchException e){
                                turnOff = true;
                                System.out.println("only numbers");
                            }

                        }while(turnOff);
                        break;
                    }

                    case 4 : {
                        boolean cycle = false;
                        do {
                            try {
                                System.out.println("write lybrary id and then book id");

                                System.out.println(bookServiceImp.deleteBook(new Scanner(System.in).nextLong(),new Scanner(System.in).nextLong()));

                            } catch (InputMismatchException e) {
                                System.out.println("only numbers");
                                cycle = true;
                            }
                        }while(cycle);

                        break;
                    }
                    case 5 : {
                        boolean cycle = false;

                        do {
                            try {
                                System.out.println("write library id ");

                                bookServiceImp.clearBooksByLibraryId(new Scanner(System.in).nextLong());
                            } catch (InputMismatchException e) {
                                System.out.println("only numbers");
                                cycle = true;
                            }
                        }while(cycle);
                        break;

                    }
                    case 6:{
                        isTrue = false;
                        break;
                    }
                    default:{
                        System.out.println("invalid command");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Type only numbers");
            }

        }

    }







    public  static Reader blankeReader (){


              System.out.println("Write name");
              String name = text.nextLine();
              System.out.println("Write email");
              String email = text.nextLine();
              System.out.println("Write number");
              String number = text.nextLine();
              Gender gender = Gender.MALE;

              boolean turnOff = true;
              do {
                  try {
                      System.out.print("""
                                            \n
                                                 GENDER
                                            
                                            1) MALE
                                            2) FEMALE
                                            
                                            <<<<<<(
                                            """);
                      int genderC = new Scanner(System.in).nextInt();
                      if (genderC == 1) {
                          turnOff = false;
                      } else if (genderC == 2) {
                          turnOff = false;
                          gender = Gender.FEMALE;
                      } else {
                          System.err.println("Invalid command");
                      }


                  } catch (InputMismatchException e) {
                      System.out.println("only numbers");
                  }
              }while(turnOff);


              return  new Reader(Generate.setIdReader(),name,email,number,gender);

      }






      public static Book blankeBook (){

          boolean isTrue = false;
          int genreC = 0;
          int count = 0 ;
          System.out.println("write book name ");
          String bName = text.nextLine();
          System.out.println("write author \n");
          String aName = text.nextLine();
          for (Genre i : genres ){
              System.out.println(count + ") " + i + "\n");
              count ++;
          }
          do {
              try {
                  genreC = new Scanner(System.in).nextInt();

              } catch (Exception e) {
                  isTrue = true;
                  System.err.println("Something went wrong");
              }
          }while(isTrue);



          return new Book(Generate.setIdBook(),bName,aName,genres[genreC]);

    }





    public static Library blankeLibrary(){
        System.out.println("write library name");
        String name = text.nextLine();
        System.out.println("write address");
        String address = text.nextLine();
        List<Book> books = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();


        return  new Library(Generate.setIdLibrary(),name,address,books,readers);
    }

}