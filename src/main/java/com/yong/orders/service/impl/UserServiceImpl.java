package com.yong.orders.service.impl;

import com.yong.orders.dao.UserCloneDao;
import com.yong.orders.dao.UserDao;
import com.yong.orders.model.Address;
import com.yong.orders.model.User;
import com.yong.orders.model.UserClone;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCloneDao userCloneDao;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User save(User user) {
        log.debug("Start User Save method.");
        UserClone user1 = new UserClone();
        BeanUtils.copyProperties(user,user1);
        user1.setAge(100);
        Address add = new Address();
        add.setAdd("XinYuan");
        add.setCountry("China");
        add.setLocation("GuangZhou");
        user1.setAddress(add);
        userCloneDao.save(user1);
        return userDao.save(user);
    }
}
