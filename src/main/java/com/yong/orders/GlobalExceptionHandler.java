package com.yong.orders;

import com.google.common.base.Throwables;
import com.yong.orders.common.Result;
import com.yong.orders.dao.ErrorLogDao;
import com.yong.orders.model.ErrorLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.yong.orders.common.ResultCode.FAIL;

/**
 * Created by LiangYong on 2017/9/12.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    @Autowired
    private ErrorLogDao dao;

        @ExceptionHandler(value = Exception.class)
        public Result errorHandler(Exception ex) {
//          String string ="ddf";
//          log.info("test string = {}",string);
//          log.info("clas = {}",ex.getClass());
//            log.info("rootCause = {}",Throwables.getRootCause(ex));
//          List<Throwable> causalChain = Throwables.getCausalChain(ex);
//          for(Throwable t :causalChain){
//          log.info("t = {}",t.toString());
            ErrorLog errorlog = ErrorLog.builder().message(Throwables.getStackTraceAsString(ex)).createdDate(new Date()).build();
            dao.save(errorlog);
            log.error(Throwables.getStackTraceAsString(ex));
            return Result.fail(FAIL, Throwables.getStackTraceAsString(ex));
        }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }
}
