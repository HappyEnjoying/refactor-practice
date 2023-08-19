package com.refactor.practice;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 租借测试
 *
 * 需求猫述:
 *
 * 有三种类型的电影，顾客可以进行租货
 *
 * 租赁规则
 * 价格计算规则:
 * 普通片：起步价2元，超过2天的部分每天每部电影收费1.5元
 * 新片：每天每部3元
 * 儿童片：起步价1.5元，超过3天的部分每天每部电影收费1.5元
 *
 * 积分计算规则:
 * 每借一部电影积分加1，新片每部加2
 *
 * @author Hejieyu
 * @version [v1, 2023年08月19日]
 */
public class CustomerTest {
	/**
	 * 顾客信息
	 */
	private Customer customer;
	private String baseline;

	@Before
	public void setUp() throws IOException {
		customer = new Customer("user1", new Vector());
		File file = new File("src/test/java/com/refactor/practice/baseline");
		baseline = FileUtils.readFileToString(file);
	}

	@Test
	public void should_get_statement_of_rentals() {
		//given
		addRental(customer, "regular movie", Movie.REGULAR, 3);
		addRental(customer, "new movie", Movie.NEW_RELEASE, 2);
		addRental(customer, "children movie", Movie.CHILDRENS, 5);
		//when
		String result = customer.statement();
		System.out.println(result);
		//then
		assertThat(result).isEqualTo(baseline);
	}

	private void addRental(Customer customer, String movieTitle, int priceCode, int dayRented) {
		customer.addRental(new Rental(new Movie(movieTitle, priceCode), dayRented));
	}
}