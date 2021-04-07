package com.ht.demo.electricitymeter.dao.bean;

import javax.persistence.*;

@Table(name = "instrument_address")
public class InstrumentAddress {
    /**
     * 地址
     */
    @Id
    private String address;

    /**
     * 仪表类型
     */
    private Integer type;

    /**
     * 线路名称
     */
    @Column(name = "address_name")
    private String addressName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取仪表类型
     *
     * @return type - 仪表类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置仪表类型
     *
     * @param type 仪表类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取线路名称
     *
     * @return address_name - 线路名称
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * 设置线路名称
     *
     * @param addressName 线路名称
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}