package com.myspring.service;

import com.myspring.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class BookService  {

//    @Autowired
    @Resource
    private BookDao bookDao;

    public void save() throws SQLException {
        System.out.println("bookservice....正在调用dao帮你保存图书。。");
        bookDao.saveBook();
    }
}
