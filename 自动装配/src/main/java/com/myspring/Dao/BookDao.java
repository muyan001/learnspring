package com.myspring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

//@Repository("bookdao1")
//@Scope(value = "prototype")

@Repository
public class BookDao {


//    @Autowired
//    private DataSource dataSource;


    public void saveBook() throws SQLException {
//        dataSource.getConnection();
        System.out.println("图书已经保存");
    }
}
