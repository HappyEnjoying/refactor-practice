package com.refactor.practice.pricepackage;

import com.refactor.practice.Movie;

/**
 * 新片对应租借费用和积分
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getAmount(int dayRented) {
        return dayRented * 3;
    }

    public int getFrequentRenterPoints(int dayRented) {
        return dayRented > 1 ? 2 : 1;
    }
}
