package com.yong.orders.controller;

import com.yong.orders.service.UserService;
import com.yong.orders.model.User;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yong.a.liang on 6/14/2017.
 */

@RestController
//@Slf4j
public class IndexController {

    @Autowired
    UserService userService;


    @GetMapping("/index")
    public String getInitMessage(){
//        log.info("test @Slf4j annotation");
         List<String> list =new ArrayList<>();
         list.add("test");
         list.get(2);
        return list.get(2);
    }

    @GetMapping("/info")
    public boolean getInitInfo(){
        return true;
    }
    }
