package com.ht.demo.electricitymeter.dao.bean;

import java.math.BigDecimal;

import com.ht.demo.electricitymeter.util.ByteUtils;

import lombok.Data;

@Data
public class PD194EData {
    private Integer address = 01;//地址

    private String addressName = "测试线路";//地址

    private Integer  relay01 = 0;//继电器01
    private Integer  relay02 = 0;//继电器02
    private Integer  relay03 = 0;//继电器03

    private Integer  switch01 = 0;//开关量01
    private Integer  switch02 = 0;//开关量02
    private Integer  switch03 = 0;//开关量03
    private Integer  switch04 = 0;//开关量04

    private BigDecimal  uab = BigDecimal.ZERO;//寄存器000C-000D
    private BigDecimal  ubc = BigDecimal.ZERO;//寄存器000E-000F
    private BigDecimal  uca = BigDecimal.ZERO;//寄存器0010-0011
    private BigDecimal  ia = BigDecimal.ZERO;//寄存器0012-0013
    private BigDecimal  ib = BigDecimal.ZERO;//寄存器0014-0015
    private BigDecimal  ic = BigDecimal.ZERO;//寄存器0016-0017
    private BigDecimal  pa = BigDecimal.ZERO;//寄存器0018-0019
    private BigDecimal  pb = BigDecimal.ZERO;//寄存器001A-001B
    private BigDecimal  pc = BigDecimal.ZERO;//寄存器001C-001D
    private BigDecimal  p0 = BigDecimal.ZERO;//寄存器001E-001F
    private BigDecimal  q0 = BigDecimal.ZERO;//寄存器0026-0027
    private BigDecimal  rate = BigDecimal.ZERO;//寄存器002A-002B
    private BigDecimal  w0 = BigDecimal.ZERO;//寄存器002E-002F


    public void parserelayData(String data){
        int hex = Integer.parseInt(data,16);
        if((hex&1)==1){
            relay01=1;
        }
        if((hex&2)==1){
            relay02=1;
        }
        if((hex&4)==1){
            relay03=1;
        }
    }

    public void parseSwitchData(String data){
        int hex = Integer.parseInt(data,16);
        if((hex&1)==1){
            switch01=1;
        }
        if((hex&2)==1){
            switch02=1;
        }
        if((hex&4)==1){
            switch03=1;
        }
        if((hex&8)==1){
            switch04=1;
        }
    }

    public void parseData(String data){
        for(int i=0;i<data.length()/4;i++){
            //通过i，判断这是哪一个数据
            switch(i){
                case 6:uab=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 7:ubc=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 8:uca=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 9:ia=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 10:ib=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 11:ic=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 12:pa=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 13:pb=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 14:pc=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 15:p0=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 19:q0=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 21:rate=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 23:w0=new BigDecimal(ByteUtils.getBlockData(i,data));
            }
        }
    }


}
