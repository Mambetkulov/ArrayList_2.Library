package service.imp;

import dao.imp.ReaderDaoImp;
import database.DataBase;
import models.Reader;
import service.ReaderService;

import java.util.List;

public class ReaderServiceImp implements ReaderService {
    private final ReaderDaoImp readerDaoImp;

    public ReaderServiceImp(ReaderDaoImp readerDaoImp) {
        this.readerDaoImp = readerDaoImp;
    }

    @Override
    public void saveReader(Reader reader) {
       readerDaoImp.saveReader(reader);
        System.out.println("successfully saved");
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerDaoImp.getAllReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        for(Reader i : DataBase.readers){
            if(i.getId().equals(id)){
                return readerDaoImp.getReaderById(id);
            }
        }

        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for(Reader i : DataBase.readers) {
            if (i.getId().equals(id)) {
                return readerDaoImp.updateReader(id,reader);
            }
        }

        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        boolean isTrue = true;
        for(Reader i : DataBase.readers) {
            if (i.getId().equals(readerId)) {
                isTrue = false;
                readerDaoImp.assignReaderToLibrary(readerId,libraryId);
            }
        }
        if(isTrue) System.out.println("Reader with this id not found");

    }
}
