package com.yong.orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

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
