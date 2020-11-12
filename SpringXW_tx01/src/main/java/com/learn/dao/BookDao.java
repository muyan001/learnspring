package com.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 1.减余额操作
     *
     *  减去某个用户的余额
     */
    public void updateBalance(String userName,int balance){
        String sql = "update account SET balance=balance-? WHERE username = ?;";
        jdbcTemplate.update(sql,balance,userName);

    }


    /**
     *  2.获取某本图书的价格，
     */

    public int getPrice(String isbn){

        String sql = "SELECT price FROM book WHERE isbn=?;";

        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    /**
     *  3. 减去库存
     *
     *  减去某本书的库存，为了简单 起见，每次只减1
     */


    public void updateStock(String isbn){

        String sql = "UPDATE 123 book_stock SET stock = stock-1 WHERE isbn=?;";

        jdbcTemplate.update(sql,isbn);



    }


}
