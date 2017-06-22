package com.yong.orders.controller;

import com.netflix.appinfo.AmazonInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by yong.a.liang on 6/14/2017.
 */
@Configuration
public class EurekaConfig {
    private final static Logger LOG = LoggerFactory.getLogger(EurekaConfig.class);
//
//    @Value("${server.port:8761}")
//    private int port;
//
//    @Profile("!default")
//    @Bean
//    @Autowired
//    public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
//        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
//        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
//        config.setHostname(info.get(AmazonInfo.MetaDataKey.localHostname));
//        config.setIpAddress(info.get(AmazonInfo.MetaDataKey.localIpv4));
//        config.setNonSecurePort(port);
//        config.setDataCenterInfo(info);
//        LOG.info("Amazon info object: " + info);
//        return config;
//    }
}
