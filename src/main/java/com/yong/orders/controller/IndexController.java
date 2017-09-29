package com.yong.orders.controller;

import com.yong.orders.service.UserService;
import com.yong.orders.model.User;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

/**
 * Created by yong.a.liang on 6/14/2017.
 */

@RestController
@Slf4j
public class IndexController {

    @Autowired
    UserService userService;

    private static final DateTimeFormatter DATE_TIME_NANOSECONDS_OFFSET_FORMATTER =
            new DateTimeFormatterBuilder().parseCaseInsensitive().append(ISO_LOCAL_DATE_TIME)
                    .appendFraction(ChronoField.NANO_OF_SECOND, 0, 3, true)
                    .appendOffset("+HH:mm", "Z")
                    .toFormatter();

    @GetMapping("/index")
    public String getInitMessage(){
//        log.info("test @Slf4j annotation");
         List<String> list =new ArrayList<>();
         list.add("test");
         list.get(2);
        return list.get(2);
    }

    @GetMapping("/info")
    public ZonedDateTime getInitInfo(@RequestParam String zonedDateTime){
//        zonedDateTime = zonedDateTime + "T00:00:00Z";
        log.debug("zonedDateTime = {}",zonedDateTime);
//        2017-07-12T07:00:00 08:00[Asia/Macau]
        ZonedDateTime z1 = ZonedDateTime.parse(zonedDateTime,DATE_TIME_NANOSECONDS_OFFSET_FORMATTER);
        log.debug("testZoneDate = {}",z1);
        return z1;
    }
}
