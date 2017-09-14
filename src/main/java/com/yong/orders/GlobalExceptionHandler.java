package com.yong.orders;

import com.yong.orders.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import static com.yong.orders.common.ResultCode.FAIL;

/**
 * Created by LiangYong on 2017/9/12.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @InitBinder
    public void initBinder(WebDataBinder binder) {}


        @ExceptionHandler(value = Exception.class)
        public Result errorHandler(Exception ex) {
        String string ="ddf";
        log.info("test string = {}",string);
        log.info("handle Exception ! {}",ex.getMessage());
        return Result.fail(FAIL,ex.getMessage());
     }
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }
}
