package com.spring.dao;

import com.spring.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {


    public void save() {


        System.out.println("BookeDao..... 保存图书");


    }
}
