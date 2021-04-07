package com.ht.demo.electricitymeter.dao.bean;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "instrument_data_record")
public class InstrumentDataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 地址
     */
    private String address;

    /**
     * 继电器1
     */
    private Integer relay01;

    /**
     * 继电器2
     */
    private Integer relay02;

    /**
     * 继电器3
     */
    private Integer relay03;

    /**
     * 开关量01
     */
    private Integer switch01;

    /**
     * 开关量02
     */
    private Integer switch02;

    /**
     * 开关量03
     */
    private Integer switch03;

    /**
     * 开关量04
     */
    private Integer switch04;

    /**
     * ab线电压

     */
    private BigDecimal uab;

    /**
     * bc线电压

     */
    private BigDecimal ubc;

    /**
     * ca线电压

     */
    private BigDecimal uca;

    /**
     * a相电流

     */
    private BigDecimal ia;

    /**
     * b相电流

     */
    private BigDecimal ib;

    /**
     * c相电流

     */
    private BigDecimal ic;

    /**
     * a相有功功率

     */
    private BigDecimal pa;

    /**
     * b相有功功率

     */
    private BigDecimal pb;

    /**
     * c相有功功率

     */
    private BigDecimal pc;

    /**
     * 总有功功率

     */
    private BigDecimal p0;

    /**
     * 总无功功率

     */
    private BigDecimal q0;

    /**
     * 总功率因数

     */
    private BigDecimal rate;

    /**
     * 正向有功
     */
    private BigDecimal w0;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取继电器1
     *
     * @return relay01 - 继电器1
     */
    public Integer getRelay01() {
        return relay01;
    }

    /**
     * 设置继电器1
     *
     * @param relay01 继电器1
     */
    public void setRelay01(Integer relay01) {
        this.relay01 = relay01;
    }

    /**
     * 获取继电器2
     *
     * @return relay02 - 继电器2
     */
    public Integer getRelay02() {
        return relay02;
    }

    /**
     * 设置继电器2
     *
     * @param relay02 继电器2
     */
    public void setRelay02(Integer relay02) {
        this.relay02 = relay02;
    }

    /**
     * 获取继电器3
     *
     * @return relay03 - 继电器3
     */
    public Integer getRelay03() {
        return relay03;
    }

    /**
     * 设置继电器3
     *
     * @param relay03 继电器3
     */
    public void setRelay03(Integer relay03) {
        this.relay03 = relay03;
    }

    /**
     * 获取开关量01
     *
     * @return switch01 - 开关量01
     */
    public Integer getSwitch01() {
        return switch01;
    }

    /**
     * 设置开关量01
     *
     * @param switch01 开关量01
     */
    public void setSwitch01(Integer switch01) {
        this.switch01 = switch01;
    }

    /**
     * 获取开关量02
     *
     * @return switch02 - 开关量02
     */
    public Integer getSwitch02() {
        return switch02;
    }

    /**
     * 设置开关量02
     *
     * @param switch02 开关量02
     */
    public void setSwitch02(Integer switch02) {
        this.switch02 = switch02;
    }

    /**
     * 获取开关量03
     *
     * @return switch03 - 开关量03
     */
    public Integer getSwitch03() {
        return switch03;
    }

    /**
     * 设置开关量03
     *
     * @param switch03 开关量03
     */
    public void setSwitch03(Integer switch03) {
        this.switch03 = switch03;
    }

    /**
     * 获取开关量04
     *
     * @return switch04 - 开关量04
     */
    public Integer getSwitch04() {
        return switch04;
    }

    /**
     * 设置开关量04
     *
     * @param switch04 开关量04
     */
    public void setSwitch04(Integer switch04) {
        this.switch04 = switch04;
    }

    /**
     * 获取ab线电压

     *
     * @return uab - ab线电压

     */
    public BigDecimal getUab() {
        return uab;
    }

    /**
     * 设置ab线电压

     *
     * @param uab ab线电压

     */
    public void setUab(BigDecimal uab) {
        this.uab = uab;
    }

    /**
     * 获取bc线电压

     *
     * @return ubc - bc线电压

     */
    public BigDecimal getUbc() {
        return ubc;
    }

    /**
     * 设置bc线电压

     *
     * @param ubc bc线电压

     */
    public void setUbc(BigDecimal ubc) {
        this.ubc = ubc;
    }

    /**
     * 获取ca线电压

     *
     * @return uca - ca线电压

     */
    public BigDecimal getUca() {
        return uca;
    }

    /**
     * 设置ca线电压

     *
     * @param uca ca线电压

     */
    public void setUca(BigDecimal uca) {
        this.uca = uca;
    }

    /**
     * 获取a相电流

     *
     * @return ia - a相电流

     */
    public BigDecimal getIa() {
        return ia;
    }

    /**
     * 设置a相电流

     *
     * @param ia a相电流

     */
    public void setIa(BigDecimal ia) {
        this.ia = ia;
    }

    /**
     * 获取b相电流

     *
     * @return ib - b相电流

     */
    public BigDecimal getIb() {
        return ib;
    }

    /**
     * 设置b相电流

     *
     * @param ib b相电流

     */
    public void setIb(BigDecimal ib) {
        this.ib = ib;
    }

    /**
     * 获取c相电流

     *
     * @return ic - c相电流

     */
    public BigDecimal getIc() {
        return ic;
    }

    /**
     * 设置c相电流

     *
     * @param ic c相电流

     */
    public void setIc(BigDecimal ic) {
        this.ic = ic;
    }

    /**
     * 获取a相有功功率

     *
     * @return pa - a相有功功率

     */
    public BigDecimal getPa() {
        return pa;
    }

    /**
     * 设置a相有功功率

     *
     * @param pa a相有功功率

     */
    public void setPa(BigDecimal pa) {
        this.pa = pa;
    }

    /**
     * 获取b相有功功率

     *
     * @return pb - b相有功功率

     */
    public BigDecimal getPb() {
        return pb;
    }

    /**
     * 设置b相有功功率

     *
     * @param pb b相有功功率

     */
    public void setPb(BigDecimal pb) {
        this.pb = pb;
    }

    /**
     * 获取c相有功功率

     *
     * @return pc - c相有功功率

     */
    public BigDecimal getPc() {
        return pc;
    }

    /**
     * 设置c相有功功率

     *
     * @param pc c相有功功率

     */
    public void setPc(BigDecimal pc) {
        this.pc = pc;
    }

    /**
     * 获取总有功功率

     *
     * @return p0 - 总有功功率

     */
    public BigDecimal getP0() {
        return p0;
    }

    /**
     * 设置总有功功率

     *
     * @param p0 总有功功率

     */
    public void setP0(BigDecimal p0) {
        this.p0 = p0;
    }

    /**
     * 获取总无功功率

     *
     * @return q0 - 总无功功率

     */
    public BigDecimal getQ0() {
        return q0;
    }

    /**
     * 设置总无功功率

     *
     * @param q0 总无功功率

     */
    public void setQ0(BigDecimal q0) {
        this.q0 = q0;
    }

    /**
     * 获取总功率因数

     *
     * @return rate - 总功率因数

     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 设置总功率因数

     *
     * @param rate 总功率因数

     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 获取正向有功
     *
     * @return w0 - 正向有功
     */
    public BigDecimal getW0() {
        return w0;
    }

    /**
     * 设置正向有功
     *
     * @param w0 正向有功
     */
    public void setW0(BigDecimal w0) {
        this.w0 = w0;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}