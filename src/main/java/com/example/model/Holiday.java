package com.example.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 繁星
 * @date 2020年5月15日14:19:33
 */
@Data
@ApiModel("节假日")
public class Holiday {

    @ApiModelProperty(" 唯一标识 ")
    private Integer id;

    @ApiModelProperty(" 每天 YYYY/MM/dd ")
    private String everyday;

    @ApiModelProperty("状态 0:工作日 1:法定节假日 2:休息日正常上班 3:休息日 ")
    private String status;
}
