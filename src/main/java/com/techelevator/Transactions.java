package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions {
	CurrentBalance balance;
	private boolean isComplete = false;
	
	public CurrentBalance getBalance() {
		return balance;
	}
	

	public void transactionComplete() {
		isComplete = true;
	}

	public boolean getTransactionStatus() {
		return isComplete;
	}

	public void printTransaction(String itemName, String itemLocation, int itemPrice) throws IOException {
		File transactionLog = new File("transactionLogtxt");
		if (!transactionLog.exists()) {
			try {
				transactionLog.createNewFile();
			} catch (IOException e) {
				System.out.println("Something went wrong");
			}
			try (PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true))) {
				pw.println("DateTime     |Product|Slot|AmountAccepted|Balance");

			}

		}
		try(PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true))) {
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");
			pw.print(formatter.format(dateTime) + " | ");
			pw.print(itemName + " | ");
			pw.print(itemLocation + " | ");
			pw.print(getBalance() + " | ");
			pw.print(getBalance(balance - itemPrice));
		}
	}
}
