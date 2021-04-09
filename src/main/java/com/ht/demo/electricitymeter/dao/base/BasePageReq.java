package com.ht.demo.electricitymeter.dao.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @描述: 分页查询对象
 * @作者 hantao
 * @更新时间 2020/5/18
 */
@Data
public class BasePageReq  {

    @ApiModelProperty(value = "当前页码")
    private Integer pageNum;
    @ApiModelProperty(value = "每页显示条数")
    private Integer pageSize;
    /**
     * 排序字段
     */
    @JsonIgnore
    private String orderParam;
    /**
     * 排序类型 升降序  ASC DESC
     */
    @JsonIgnore
    private String orderType;

    public static BasePageReq PageAll() {
        return new BasePageReq(1, 0);
    }

    public BasePageReq() {
        this.pageNum = 1;
        this.pageSize = 20;
    }

    public BasePageReq(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }


}
