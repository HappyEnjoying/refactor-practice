package com.refactor.practice.pricepackage;

/**
 * 获取电影类型对应租借费用和积分
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public abstract class Price {
    /**
     * 获取电影类型
     * @return 电影类型编码
     */
    public abstract int getPriceCode();

    /**
     * 根据租借天数计算金额
     * @param dayRented 租借天数
     * @return 租借金额
     */
    public abstract double getAmount(int dayRented);

    /**
     * 默认返回积分1
     * @param dayRented 租借天数
     * @return 积分
     */
    public int getFrequentRenterPoints(int dayRented) {
        return 1;
    }
}
