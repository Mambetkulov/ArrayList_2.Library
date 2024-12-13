package service.imp;

import dao.imp.LibraryDaoImp;
import database.DataBase;
import models.Library;
import service.LibraryService;

import java.util.List;

public class LibraryServiceImp implements LibraryService {

    private final LibraryDaoImp libraryDaoImp;

    public LibraryServiceImp(LibraryDaoImp libraryDaoImp) {
        this.libraryDaoImp = libraryDaoImp;
    }

    @Override
    public Library saveLibrary(Library library) {
        return libraryDaoImp.saveLibrary(library);
    }

    @Override
    public List<Library> getAllLibraries() {

        return libraryDaoImp.getAllLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        for(Library i : DataBase.libraries){
            if(i.getId().equals(id)){
                return libraryDaoImp.getLibraryById(id);
            }
        }



        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library i : DataBase.libraries) {
            if (i.getId().equals(id)) {
                return libraryDaoImp.updateLibrary(id, library);
            }


        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library i : DataBase.libraries) {
            if (i.getId().equals(id)) {
                libraryDaoImp.deleteLibrary(id);
                return "successfully deleted";
            }

        }
        return "Library with this id not found";
    }

}
