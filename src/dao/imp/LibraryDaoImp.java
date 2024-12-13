package dao.imp;
import dao.LibraryDao;
import database.DataBase;
import models.Library;
import java.util.List;

public class LibraryDaoImp implements LibraryDao {

    @Override
    public Library saveLibrary(Library library) {
       DataBase.libraries.add(library);
        return  library;
    }

    @Override
    public List<Library> getAllLibraries() {
        return DataBase.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for(Library i : DataBase.libraries){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        int count = 0;
        for(Library i : DataBase.libraries){
            if(i.getId().equals(id)){
                DataBase.libraries.set(count,library);
            }
            count ++;
        }
        return library;
    }

    @Override
    public String deleteLibrary(Long id) {
        for(Library i : DataBase.libraries){
            if(i.getId().equals(id)){
                DataBase.libraries.remove(i);
                break;
            }
        }
        return "successfully deleted";
    }
}
