package com.refactor.practice;

/**
 * 租借记录
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public class Rental {
	/**
	 * 租借电影
	 */
	private Movie movie;

	/**
	 * 租借天数
	 */
	private int dayRented;

	public Rental(Movie movie, int dayRented) {
		this.movie = movie;
		this.dayRented = dayRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDayRented() {
		return dayRented;
	}

	/**
	 * 计算租借金额
	 * @return 租借金额
	 */
	public double getAmount() {
		return movie.getAmount(dayRented);
	}

	/**
	 * 计算积分
	 * @return 积分
	 */
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(dayRented);
	}
}
