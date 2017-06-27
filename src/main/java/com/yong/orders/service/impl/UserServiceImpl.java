package com.yong.orders.service.impl;

import com.yong.orders.common.Result;
import com.yong.orders.dao.UserDao;
import com.yong.orders.dao.UserSnapshotDao;
import com.yong.orders.model.User;
import com.yong.orders.model.UserSnapshot;
import com.yong.orders.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yong.a.liang on 6/21/2017.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UserDao dao;

    @Autowired
    private UserSnapshotDao userSnapshotDao;

    public UserServiceImpl(UserDao dao){
        super(dao);
        this.dao=dao;
    }

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Result<User> addOne(User user) {
        log.debug("Start User Save method.");
        doSaveUserSnapshot(user);
        dao.save(user);
        return Result.success(user);
    }



    public void doSaveUserSnapshot(User user){
        UserSnapshot user1 = new UserSnapshot();
        BeanUtils.copyProperties(user,user1);
        userSnapshotDao.save(user1);
    }
}
