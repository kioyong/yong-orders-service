package com.yong.orders.service.impl;

import com.yong.orders.dao.DepartmentGroupDao;
import com.yong.orders.model.DepartmentGroup;
import com.yong.orders.service.DepartmentGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yong.a.liang on 7/14/2017.
 */
@Service
public class DepartmentGroupServiceImpl  extends BaseServiceImpl<DepartmentGroup> implements DepartmentGroupService {



    private DepartmentGroupDao dao;

    @Autowired
    private DepartmentGroupDao departmentGroupDao;

    public DepartmentGroupServiceImpl(DepartmentGroupDao dao){
        super(dao);
        this.dao=dao;
    }

    private static final Logger log = LoggerFactory.getLogger(DepartmentGroupServiceImpl.class);
}
