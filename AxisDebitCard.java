package com.codegnan.cards;

import java.util.ArrayList;
import java.util.Collections;

import com.codegnan.customExceptions.InsufficentMachineBalanceException;
import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InvaildAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;

public class AxisDebitCard implements IATMService {
	String name;
	long debitCardNumber;
	double accountBalance;
	int pinNumber;
	ArrayList<String> statement;
	final String type = "user";
	int chances;

	public AxisDebitCard(long debitCardNumber, String name, double accountBalance, int pinNumber) {
		chances = 3;
		this.name = name;
		this.accountBalance = accountBalance;
		this.pinNumber = pinNumber;
		statement = new ArrayList<>();

	}

	public String getUserType() throws NotAOperatorException {
		return type;
	}

	public double withdrawAmount(double wthAmount)
			throws InvaildAmountException, InsufficientBalanceException, InsufficentMachineBalanceException {
		// TODO Auto-generated method stub
		if (wthAmount <= 0) {
			throw new InvaildAmountException("you can enter zero(0) amount to wuuthdraw.pls enter valid amount");
		} else if (wthAmount % 100 != 0) {
			throw new InvaildAmountException("please withdraw multiples of 100");
		} else if (wthAmount < 500) {
			throw new InsufficientBalanceException("please withdraw more than 500 rupees");
		} else if (wthAmount > accountBalance) {
			throw new InsufficientBalanceException(
					"you dont have sufficient balance to withdraw ..please check your account balance");
		} else {
			accountBalance = accountBalance - wthAmount;
			statement.add("Debited : " + wthAmount);
			return wthAmount;
		}
	}

	public void depositAmount(double deptAmount) throws InvaildAmountException {
		if (deptAmount <= 0 || deptAmount % 100 != 0 || deptAmount < 500) {// logical or = any one is true
			throw new InvaildAmountException("Please deposit multiples of 100 and deposit more than 500");
		} else {
			accountBalance = accountBalance + deptAmount;
			statement.add("credited:" + deptAmount);
		}
	}

	public double checkAccountBalance() {
		// TODO Auto-generated method stub
		return accountBalance;
	}

	public void changePinNumber(int pinNumber) {
		// TODO Auto-generated method stub
		this.pinNumber = pinNumber;

	}

	public int getPinNumber() {
		return pinNumber;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void decreaseChances() {
		--chances;

	}

	public int getChances() {
		return chances;
	}

	public void resetPinChances() {
		chances = 3;

	}

	public void generateMiniStatement() {
		int count = 5;
		if (statement.size() == 0) {
			System.out.println("there are no transactions happened");
			return;
		}
		System.out.println("==========================list of 5 transactions===================== ");
		Collections.reverse(statement);
		for (String trans : statement) {
			if (count == 0) {
				break;
			}
			System.out.println(trans);
			count--;
		}
		Collections.reverse(statement);

	}

}
