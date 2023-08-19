package com.refactor.practice.pricepackage;

import com.refactor.practice.Movie;

/**
 * 儿童片对应租借费用
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getAmount(int dayRented) {
        return dayRented > 3 ? 1.5 + (dayRented - 3) * 1.5 : 1.5;
    }
}
