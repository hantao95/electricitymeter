package com.ht.demo.electricitymeter.dao.bean;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "electricity_info")
public class ElectricityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 功率
     */
    private BigDecimal power;

    /**
     * 插入时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取功率
     *
     * @return power - 功率
     */
    public BigDecimal getPower() {
        return power;
    }

    /**
     * 设置功率
     *
     * @param power 功率
     */
    public void setPower(BigDecimal power) {
        this.power = power;
    }

    /**
     * 获取插入时间
     *
     * @return create_time - 插入时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置插入时间
     *
     * @param createTime 插入时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}