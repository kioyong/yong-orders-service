package com.yong.orders.config;

import com.yong.orders.constant.SequenceKeys;
import com.yong.orders.dao.SequenceDao;
import com.yong.orders.model.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiangYong on 2017/7/26.
 */
@Component
public class SequenceConfig implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SequenceConfig.class);

    @Autowired
    private SequenceDao dao;

    @Override
    public void run(String... strings) throws Exception {
        log.info("Start Init Sequence.");
        initSequence();
    }

    public void initSequence (){
        for (Map.Entry<String,Long> entry : SequenceKeys.sequenceKeysMap.entrySet()){
            Sequence sequence = dao.findOne(entry.getKey());
            if (null == sequence){
                log.debug("Start init {},start Value = {}",entry.getKey(),entry.getValue());
                String key = entry.getKey();
                Long value = entry.getValue();
                Sequence seq = new Sequence(key,value);
                dao.save(seq);
            }
        }
    }
}
