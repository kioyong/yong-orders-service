package com.yong.orders.service;


import com.yong.orders.common.Result;

import java.util.List;

/**
 * Created by yong.a.liang on 6/22/2017.
 */
public interface BaseService<T> {

    Result<T> addOne(T instance);
    Result<T> delete(String id);
    Result<T> getOne(String id);
    Result<T> updateOne(T instance);

    Result<List<T>> findAll();
}
