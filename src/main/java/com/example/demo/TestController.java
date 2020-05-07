package com.example.demo;

import com.example.log.PrintLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishibo
 */
@RestController
@Api(value = "/api" , tags = "测试接口" )
public class TestController {

    @RequestMapping(value = "/hi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "测试", response = String.class, notes = "测试")
    @PrintLog
    public String testOne(@RequestBody String name){
        return name + "--成功";
    }
}
