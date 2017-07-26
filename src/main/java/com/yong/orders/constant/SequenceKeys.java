package com.yong.orders.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiangYong on 2017/7/26.
 */
public class SequenceKeys {
    private static final String USER = "userConfig";

    public final static Map<String,Long> sequenceKeysMap = new HashMap<String,Long>();

    static {
        sequenceKeysMap.put(SequenceKeys.USER,0L);
    }


}
