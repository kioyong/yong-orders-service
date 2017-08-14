package com.yong.orders.controller;

import com.yong.orders.common.Result;
import com.yong.orders.model.User;
import com.yong.orders.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by yong.a.liang on 6/22/2017.
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User>{
    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    @Autowired
    public UserController(UserService service){
        super(service);
        this.service = service;
    }

    @GetMapping("/departmentGroup/{departmentGroupId}")
    public Result<List<User>> findUserByDepartmentGroup(@PathVariable String departmentGroupId){
        return service.findUserByDepartmentGroup(departmentGroupId);
    }

    @GetMapping("/departmentGroupHashMapAll")
    public Map<String,List<String>> findUserByDepartmentGroupAll(){
        return service.findUserByDepartmentGroupAll();
    }
    @GetMapping("/departmentGroupHashMap")
    public Iterator<Map.Entry<String,String>> findUserByDepartmentGroup(){
        return service.findUserByDepartmentGroupMap();
    }



}