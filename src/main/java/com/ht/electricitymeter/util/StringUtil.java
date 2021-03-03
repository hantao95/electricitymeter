package com.ht.electricitymeter.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class StringUtil {

    public static String FORMAT_SPLIT = "/";

    /**
     * @param obj
     * @描述: 对象是否为空
     * @return参数
     * @作者 LiangZhiJie
     * @更新时间 2020年5月20日
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (null == obj || "".equals(obj) || "null".equals(obj) || "[]".equals(obj)) {
            return true;
        }
        return false;
    }

    /**
     * @param list
     * @描述: 集合是否为空
     * @return参数
     * @作者 LiangZhiJie
     * @更新时间 2020年5月20日
     */
    public static boolean isNullOrEmptyList(List<?> list) {
        if (null == list || list.size() == 0) {
            return true;
        }
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * @param @param    i
     * @param @return参数
     * @描述: 返回随机数
     * @作者 丁晓忠
     * @更新时间 2020年5月28日
     */
    public static String getRandom(int i) {
        Random jjj = new Random();
        if (i == 0)
            return "";
        String jj = "";
        for (int k = 0; k < i; k++) {
            jj = jj + jjj.nextInt(9);
        }
        return jj;
    }

    /**
     * @param @param    d1
     * @param @param    d2
     * @param @return参数
     * @描述: double类型相加
     * @作者 梁志杰
     * @更新时间 2020年6月9日
     */
    public static double add(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }

    /**
     * @param @param    d1
     * @param @param    d2
     * @param @return参数
     * @描述: double类型相减
     * @作者 梁志杰
     * @更新时间 2020年6月9日
     */
    public static double sub(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * @param @param    v1
     * @param @param    v2
     * @param @return参数
     * @描述: 两个Double数相乘
     * @作者 梁志杰
     * @更新时间 2020年6月9日
     */
    public static double mul(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.multiply(b2).doubleValue();
    }

    /**
     * @param @param    v1
     * @param @param    v2
     * @param @param    scale
     * @param @return参数
     * @描述: 两个Double数相除，并保留scale位小数
     * @作者 梁志杰
     * @更新时间 2020年6月9日
     */
    public static double div(Double v1, Double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("小数位数不能小于0");
        }
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static String concatStr(String s1, String s2, String split) {
        StringBuilder sb = new StringBuilder();
        if (!StringUtil.isNullOrEmpty(s1)) {
            sb.append(s1);
        } else {
            sb.append("--");
        }
        sb.append(split);
        if (!StringUtil.isNullOrEmpty(s2)) {
            sb.append(s2);
        } else {
            sb.append("--");
        }
        return sb.toString();
    }
}
