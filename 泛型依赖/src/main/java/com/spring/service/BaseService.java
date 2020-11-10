package com.spring.service;

import com.spring.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class BaseService<T> {


    @Autowired
    BaseDao<T> baseDao;

    public void save(){

        System.out.println("自动注入的dao" + baseDao);
        baseDao.save();
    }
}
