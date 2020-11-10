package com.spring.dao;


import org.springframework.stereotype.Repository;

/**
 *   定义了基本的增删改查方法
 * @param <T>
 */

@Repository
public abstract class BaseDao<T> {

    public abstract void save();
}
