package com.yong.orders.service.impl;

import com.netflix.discovery.converters.Auto;
import com.yong.orders.common.Result;
import com.yong.orders.dao.DepartmentGroupDao;
import com.yong.orders.dao.UserDao;
import com.yong.orders.dao.UserSnapshotDao;
import com.yong.orders.model.DepartmentGroup;
import com.yong.orders.model.User;
import com.yong.orders.model.UserSnapshot;
import com.yong.orders.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by yong.a.liang on 6/21/2017.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UserDao dao;

    @Autowired
    private DepartmentGroupDao departmentGroupDao;

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

    @Override
    public Result<List<User>> findUserByDepartmentGroup(String departmentGroupId) {
        DepartmentGroup departmentGroup = departmentGroupDao.findOne(departmentGroupId);
        List<DepartmentGroup> departmentGroupList=new ArrayList<DepartmentGroup>();
        departmentGroupList.add(departmentGroup);
        List<User> userList = dao.findByDepartmentGroupList(departmentGroupList);
        return Result.success(userList);
    }

    @Override
    public Iterator<Map.Entry<String,String>> findUserByDepartmentGroupMap(){
        List<User> userList = dao.findAll();
        Map<String,String> map =new IdentityHashMap<String,String>();
        for(User user:userList){
            List<DepartmentGroup> departmentGroupList = user.getDepartmentGroup();
                for(DepartmentGroup departmentGroup : departmentGroupList){
                    map.put(departmentGroup.getId(),user.getName());
                }
        }
        Set<Map.Entry<String,String>> allSet = null ;   // 准备使用Set接收全部内容
        allSet = map.entrySet() ;
        Iterator<Map.Entry<String,String>> iter = null ;
        iter = allSet.iterator() ;
        return iter;
    }

    @Override
    public Map<String,List<String>> findUserByDepartmentGroupAll(){
        List<User> userList = dao.findAll();
        Map<String,List<String>> hashMap =new HashMap<>();
        for(User user:userList){
            List<DepartmentGroup> departmentGroupList = user.getDepartmentGroup();
            List<String> groupNameList = new ArrayList<String>();
            for(DepartmentGroup departmentGroup : departmentGroupList){
                groupNameList.add(departmentGroup.getName());
            }
            hashMap.put(user.getName(),groupNameList);
        }
        return hashMap;
    }

}
