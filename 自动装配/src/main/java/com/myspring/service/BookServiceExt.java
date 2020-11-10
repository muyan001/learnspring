package com.myspring.service;

import com.myspring.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class BookServiceExt extends BookService {

    @Autowired
    private BookDao bookDao;

    public void save() throws SQLException {
        System.out.println("BookServiceExt....正在调用dao帮你保存图书。。");
        bookDao.saveBook();
    }


}
