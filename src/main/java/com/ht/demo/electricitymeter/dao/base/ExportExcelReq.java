package com.ht.demo.electricitymeter.dao.base;


import java.util.List;

import lombok.Data;

/**
 * @描述: (这里用一句话描述这个类的作用)
 * @作者 hantao 
 * @更新时间 2020/7/21
 */
@Data
public class ExportExcelReq extends BasePageReq {

    /**
     * excel表头
     */
    private List<String> excelTitleList;
    /**
     * excel对应字段
     */
    private List<String> excelKeyList;

}
