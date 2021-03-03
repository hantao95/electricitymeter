package com.ht.electricitymeter.dao.bean;

import com.ht.electricitymeter.util.ByteUtils;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PD194EData {
    private Integer  relay01 = 0;//继电器01
    private Integer  relay02 = 0;//继电器02
    private Integer  relay03 = 0;//继电器03

    private Integer  switch01 = 0;//开关量01
    private Integer  switch02 = 0;//开关量02
    private Integer  switch03 = 0;//开关量03
    private Integer  switch04 = 0;//开关量04

    private BigDecimal  Uab = BigDecimal.ZERO;//寄存器000C-000D
    private BigDecimal  Ubc = BigDecimal.ZERO;//寄存器000E-000F
    private BigDecimal  Uca = BigDecimal.ZERO;//寄存器0010-0011
    private BigDecimal  Ia = BigDecimal.ZERO;//寄存器0012-0013
    private BigDecimal  Ib = BigDecimal.ZERO;//寄存器0014-0015
    private BigDecimal  Ic = BigDecimal.ZERO;//寄存器0016-0017
    private BigDecimal  Pa = BigDecimal.ZERO;//寄存器0018-0019
    private BigDecimal  Pb = BigDecimal.ZERO;//寄存器001A-001B
    private BigDecimal  Pc = BigDecimal.ZERO;//寄存器001C-001D
    private BigDecimal  P0 = BigDecimal.ZERO;//寄存器001E-001F
    private BigDecimal  Q0 = BigDecimal.ZERO;//寄存器0026-0027
    private BigDecimal  Rate = BigDecimal.ZERO;//寄存器002A-002B
    private BigDecimal  W0 = BigDecimal.ZERO;//寄存器002E-002F


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
                case 6:Uab=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 7:Ubc=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 8:Uca=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 9:Ia=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 10:Ib=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 11:Ic=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 12:Pa=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 13:Pb=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 14:Pc=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 15:P0=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 19:Q0=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 21:Rate=new BigDecimal(ByteUtils.getBlockData(i,data));
                case 23:W0=new BigDecimal(ByteUtils.getBlockData(i,data));
            }
        }
    }


}
