package com.refactor.practice;

import com.refactor.practice.pricepackage.ChildrensPrice;
import com.refactor.practice.pricepackage.NewReleasePrice;
import com.refactor.practice.pricepackage.Price;
import com.refactor.practice.pricepackage.RegularPrice;

/**
 * 电影类
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public class Movie {
	/**
	 * 普通片
	 */
	public static final int REGULAR = 0;

	/**
	 * 新片
	 */
	public static final int NEW_RELEASE = 1;

	/**
	 * 儿童片
	 */
	public static final int CHILDRENS = 2;

	/**
	 * 电影名称
	 */
	private String title;

	/**
	 * 电影类型
	 */
	private int priceCode;

	/**
	 * 电影类型对应租借费用和积分
	 */
	private Price price;

	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}

	public String getTitle() {
		return title;
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
			case REGULAR:
				price = new RegularPrice();
				break;
			case NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			case CHILDRENS:
				price = new ChildrensPrice();
				break;
			default:
				throw new IllegalArgumentException("电影类型不正确");
		}
	}

	/**
	 * 计算租借金额
	 * @return 租借金额
	 */
	public double getAmount(int dayRented) {
		return price.getAmount(dayRented);
	}

	/**
	 * 计算积分
	 * @return 积分
	 */
	public int getFrequentRenterPoints(int dayRented) {
		return price.getFrequentRenterPoints(dayRented);
	}
}
