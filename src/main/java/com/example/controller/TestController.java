package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.log.PrintLog;
import com.example.model.Holiday;
import com.example.service.HolidayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author 繁星
 */
@RestController
@Api(value = "/api" , tags = "测试接口" )
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private HolidayService holidayService;

    @RequestMapping(value = "/hi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "测试", response = String.class, notes = "测试")
    @PrintLog
    public String testOne(@RequestBody String name){
        return name + "--成功";
    }

    @RequestMapping(value = "/holidayValidate", method = RequestMethod.POST)
    @ApiOperation(value = "节假日判断", response = String.class, notes = "节假日判断")
    public String holidayValidate(@RequestParam("date") String date){
        logger.info("入参：{}", JSON.toJSONString(date));
        Holiday holiday = holidayService.getHoliday(date);
        return JSON.toJSONString(holiday);
    }
}
