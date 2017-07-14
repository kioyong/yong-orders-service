package com.yong.orders.service;

import com.yong.orders.common.Result;
import com.yong.orders.model.User;

import java.util.*;

/**
 * Created by yong.a.liang on 6/21/2017.
 */


public interface UserService extends BaseService<User>{
    Result<List<User>> findUserByDepartmentGroup(String departmentGroupId);
    Map<String,List<String>> findUserByDepartmentGroupAll();
    Iterator<Map.Entry<String,String>> findUserByDepartmentGroupMap();
}
