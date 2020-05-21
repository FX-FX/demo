package com.example.controller;

import com.alibaba.fastjson.JSON;
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
@Api(value = "/holiday" , tags = "日期校验接口")
public class HolidayController {

    private static final Logger logger = LoggerFactory.getLogger(HolidayController.class);
    @Autowired
    private HolidayService holidayService;

    @ApiOperation(value = "日期校验", response = Holiday.class, notes = "日期校验")
    @RequestMapping(value = "/dateValidate",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public Holiday dateValidate(@RequestParam("date") String date){
        logger.info("日期校验接口-入参:{}",date);
        Holiday holiday = holidayService.getHoliday(date);
        logger.info("日期校验接口-返参:{}", JSON.toJSONString(holiday));
        return holiday;
    }

}
