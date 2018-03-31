package com.library.service;

import com.library.dao.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryDao libraryDao;

    @Transactional
    public List getBooks() {
        return libraryDao.getBooks();
    }
}
