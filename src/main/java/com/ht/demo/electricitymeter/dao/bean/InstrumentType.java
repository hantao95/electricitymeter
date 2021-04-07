package com.ht.demo.electricitymeter.dao.bean;

import javax.persistence.*;

@Table(name = "instrument_type")
public class InstrumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仪表类型
     */
    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仪表类型
     *
     * @return name - 仪表类型
     */
    public String getName() {
        return name;
    }

    /**
     * 设置仪表类型
     *
     * @param name 仪表类型
     */
    public void setName(String name) {
        this.name = name;
    }
}