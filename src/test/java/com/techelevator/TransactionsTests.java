package com.techelevator;
import org.junit.Assert;
import org.junit.Test;
public class TransactionsTests {
	@Test
	public void feedMoney_test() {
		Transactions test = new Transactions();
		String actual = test.feedMoney(5);
		Assert.assertEquals("5 dollars accepted", actual );
	}

}