package com.yong.orders.controller;

import com.yong.orders.common.Result;
import com.yong.orders.common.ResultCode;
import com.yong.orders.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yong.a.liang on 6/22/2017.
 */

public class BaseController<T> {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    private BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @PostMapping
    Result<T> addOne(@RequestBody T instance) {
        try {
            return service.addOne(instance);
        } catch (Exception err) {
            logger.error("addOne error", err);
            return Result.fail(ResultCode.ARGUMENT_EXCEPTION, err.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    Result<T> deactivate(@PathVariable String id) {
        try {
            return service.delete(id);
        } catch (Exception err) {
            logger.error("deactivate error", err);
            return Result.fail(ResultCode.ARGUMENT_EXCEPTION, err.getMessage());
        }
    }

    @GetMapping
    public Result<List<T>> findAll() {
        try {
            logger.debug("start findAll.");
            return service.findAll();
        } catch (Exception err) {
            logger.error("findAll error", err);
            return Result.fail(ResultCode.ARGUMENT_EXCEPTION, err.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result<T> getOne(@PathVariable String id) {
        try {
            return service.getOne(id);
        } catch (Exception err) {
            logger.error("getOne error", err);
            return Result.fail(ResultCode.ARGUMENT_EXCEPTION, err.getMessage());
        }
    }

    @PutMapping
    Result<T> updateOne(@RequestBody T instance) {
        try {
            return service.updateOne(instance);
        } catch (Exception err) {
            logger.error("updateOne error", err);
            return Result.fail(ResultCode.ARGUMENT_EXCEPTION, err.getMessage());
        }
    }
}