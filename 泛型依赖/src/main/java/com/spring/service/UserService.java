package com.spring.service;

import com.spring.bean.User;
import com.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{


//    @Autowired
//    UserDao userDao;
//
//    public void save(){
//        System.out.println("UserDao ........ 保存用户");
//    }
}
