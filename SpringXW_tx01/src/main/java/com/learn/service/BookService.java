package com.learn.service;

import com.learn.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     *  结账方法:传入哪个用户，买了那本书
     */


    @Transactional
    public void checkout(String userName,String isbn){

        //1.减库存
        bookDao.updateStock(isbn);

        int price = bookDao.getPrice(isbn);

        //2.减余额
        bookDao.updateBalance(userName,price);



    }
}
