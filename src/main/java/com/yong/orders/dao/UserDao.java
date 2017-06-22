package com.yong.orders.dao;

import com.yong.orders.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yong.a.liang on 6/20/2017.
 */
public interface UserDao extends MongoRepository<User,String> {
}
