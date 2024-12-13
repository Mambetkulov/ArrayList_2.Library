package dao.imp;

import dao.ReaderDao;
import database.DataBase;
import models.Library;
import models.Reader;
import java.util.List;

public class ReaderDaoImp implements ReaderDao {



    @Override
    public void saveReader(Reader reader) {
         DataBase.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return DataBase.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for(Reader i : DataBase.readers){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        int count = 0;
        for(Reader i : DataBase.readers){
           if(i.getId().equals(id)) {
              DataBase.readers.set(count , reader);
              break;
           }
           count ++;
        }
        return reader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for(Library i : DataBase.libraries) {
            if (i.getId().equals(libraryId)) {
                for(Reader j : DataBase.readers){
                    if(j.getId().equals(readerId)){
                        i.setReaders(j);
                    }
                }

            }
        }
    }


}
