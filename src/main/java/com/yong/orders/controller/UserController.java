package com.yong.orders.controller;

import com.yong.orders.model.User;
import com.yong.orders.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yong.a.liang on 6/22/2017.
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User>{
    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service){
        super(service);
        this.service = service;
    }

}