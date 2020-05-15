package com.example.controller;

import com.example.log.PrintLog;
import com.example.model.Holiday;
import com.example.service.HolidayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 繁星
 */
@RestController
@Api(value = "/api" , tags = "测试接口" )
public class TestController {

    @Autowired
    private HolidayService holidayService;

    @RequestMapping(value = "/hi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "测试", response = String.class, notes = "测试")
    @PrintLog
    public String testOne(@RequestBody String name){
        return name + "--成功";
    }

    @RequestMapping(value = "/holidayValidate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "节假日判断", response = String.class, notes = "节假日判断")
    @PrintLog
    public String holidayValidate(String date){
        Holiday holiday = holidayService.getHoliday(date);
        return holiday.getStatus();
    }
}
