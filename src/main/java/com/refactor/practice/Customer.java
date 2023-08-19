package com.refactor.practice;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客信息
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public class Customer {
	/**
	 * 顾客姓名
	 */
	private String name;

	/**
	 * 顾客租借记录
	 */
	private Vector rentals;

	public Customer(String name, Vector rentals) {
		this.name = name;
		this.rentals = rentals;
	}

	public String getName() {
		return name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	/**
	 * 根据消费记录返回消费详情
	 * @return 消费详情
	 */
	public String statement() {
		//总消费金额
		double totalAmount = 0;
		//总积分
		int frequentRenterPoints = 0;
		Enumeration rentalsAll = rentals.elements();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		while (rentalsAll.hasMoreElements()) {
			Rental each = (Rental) rentalsAll.nextElement();

			//add frequent renter points
			frequentRenterPoints += each.getFrequentRenterPoints();

			//show figures for this rental
			result.append("\t")
					.append(each.getMovie().getTitle()).append("\t")
					.append(each.getAmount())
					.append("\n");
			totalAmount += each.getAmount();
		}
		//add footer lines
		result.append("Amount owed is ")
				.append(totalAmount)
				.append("\n");
		result.append("You earned")
				.append(frequentRenterPoints)
				.append(" frequent renter points");

		return result.toString();
	}
}
