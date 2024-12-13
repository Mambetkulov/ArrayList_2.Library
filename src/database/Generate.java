package database;

public class Generate {

    private static Long idLibrary = 1L;
    private static Long idReader = 1L;
    private static Long idBook = 1L;

    public static Long setIdLibrary (){
        return idLibrary ++;
    }

    public static Long setIdBook (){
        return idBook ++;
    }

    public static Long setIdReader (){
        return idReader ++;
    }
}
