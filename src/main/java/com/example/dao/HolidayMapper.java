package com.example.dao;

import com.example.model.Holiday;
import org.apache.ibatis.annotations.Param;

/**
 * @author 繁星
 * @date 2020年5月15日14:55:30
 */
public interface HolidayMapper {

    /**
     * 根据时间获取对应的状态
     * @param date
     * @return
     */
    Holiday getHoliday(@Param("date") String date);


    Holiday selectHoliday(@Param("id") Integer id);

}
