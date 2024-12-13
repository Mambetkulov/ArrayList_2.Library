package dao;

import models.Library;

import java.util.ArrayList;
import java.util.List;

public interface LibraryDao {

    Library saveLibrary(Library librarie);

    List<Library> getAllLibraries();

    Library getLibraryById (Long id);

    Library updateLibrary (Long id, Library library);

    String deleteLibrary (Long id);
}
