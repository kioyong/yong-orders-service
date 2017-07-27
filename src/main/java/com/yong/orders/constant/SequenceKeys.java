package com.yong.orders.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiangYong on 2017/7/26.
 */
public class SequenceKeys {
    public static final String USER = "userConfig";
    public static final String DEPARTMENT_GROUP = "departmentGroup";

    public final static Map<String,Long> sequenceKeysMap = new HashMap<String,Long>();

    static {
        sequenceKeysMap.put(SequenceKeys.USER,1000L);
        sequenceKeysMap.put(SequenceKeys.DEPARTMENT_GROUP,1000L);
    }


}
