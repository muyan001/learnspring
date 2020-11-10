package com.spring.service;

import com.spring.bean.Book;
import com.spring.bean.User;
import com.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book> {


//    @Autowired
//    BookDao bookDao;
//
//    public void save(){
//        System.out.println( "BookDao.........保存图书");
//    }

}
