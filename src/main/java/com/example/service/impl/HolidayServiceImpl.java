package com.example.service.impl;

import com.example.dao.HolidayMapper;
import com.example.model.Holiday;
import com.example.service.HolidayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 节假日校验实现类
 * @author 繁星
 * @date 2020年5月15日15:20:10
 */
@Service
public class HolidayServiceImpl implements HolidayService {

    @Resource
    private HolidayMapper holidayMapper;

    @Override
    public Holiday getHoliday(String date) {

        return holidayMapper.getHoliday(date);
    }

    @Override
    public Holiday selectHoliday(Integer id) {
        return holidayMapper.selectHoliday(id);
    }
}
