package com.example.service;

import com.example.model.Holiday;

/**
 * @author 繁星
 */
public interface HolidayService {

    /**
     * 根据data获取状态
     * @param date
     * @return
     */
    Holiday getHoliday(String date);

    Holiday selectHoliday(Integer id);
}
