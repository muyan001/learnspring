package com.spring.dao;

import com.spring.bean.User;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao extends BaseDao<User> {

    public void save() {

        System.out.println("UserDao ...... 保存用户");
    }
}
