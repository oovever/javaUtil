package util;

import java.math.BigDecimal;

/**
 * Created by OovEver on 2017/11/19.
 * 为了解决double浮点数加减乘除丢失精度问题，开发bigdecimalUtil工具类进行浮点数的运算
 */
public class BigDecimalUtil {
    private BigDecimalUtil() {

    }

    /**
     *
     * @param v1　相加的第一个数
     * @param v2 相加的第二个数
     * @return 相加后的结果
     */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }
    /**
     *
     * @param v1　相减的第一个数
     * @param v2 相减的第二个数
     * @return 相减后的结果
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }
    /**
     *
     * @param v1 相乘的第一个数
     * @param v2 相乘的第二个数
     * @return 相乘后的结果
     */
    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }
    /**
     *
     * @param v1　被除数
     * @param v2 除数
     * @return 相除后的结果
     */
    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);//四舍五入,保留2位小数

        //除不尽的情况
    }
}
