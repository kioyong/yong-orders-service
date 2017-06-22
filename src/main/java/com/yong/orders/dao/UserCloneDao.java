package com.yong.orders.dao;

import com.yong.orders.model.UserClone;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yong.a.liang on 6/21/2017.
 */
public interface UserCloneDao extends MongoRepository<UserClone,String> {
}
