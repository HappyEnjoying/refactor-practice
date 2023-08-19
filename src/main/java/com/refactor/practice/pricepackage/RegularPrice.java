package com.refactor.practice.pricepackage;

import com.refactor.practice.Movie;

/**
 * 普通片对应租借费用
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getAmount(int dayRented) {
       return dayRented > 2 ? 2 + (dayRented - 2) * 1.5 : 2;
    }
}
