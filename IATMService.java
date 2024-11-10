package com.codegnan.interfaces;

import com.codegnan.customExceptions.InsufficentMachineBalanceException;
import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InvaildAmountException;
import com.codegnan.customExceptions.NotAOperatorException;

public interface IATMService {
	// to get the user type. wheter the user is operator or normal user.
	public abstract String getUserType() throws NotAOperatorException;

//to withdrawAmount
	// 1. will throw InvaildAmountException if the Amount is not a valid
	// denomination.
	// 2. will throw InsufficientBalanceException if the customer has insufficient
	// amount in her/his account.
	// 3. will throw Insufficient MachineBalanceException if the machine has
	// Insufficient cash.
	public abstract double withdrawAmount(double withAmount)
			throws InvaildAmountException, InsufficientBalanceException, InsufficentMachineBalanceException;

//to deposit amount
	public abstract void depositAmount(double deptAmount) throws InvaildAmountException;

	// to check balance
	public abstract double checkAccountBalance();

	// to change PIN number
	public abstract void changePinNumber(int pinNumber);

	// get pin number
	public abstract int getPinNumber();

	// to get the user name
	public abstract String getUserName();

	// to decrease the number of chances while entering the wrong pin number
	public abstract void decreaseChances();

	// to get the chances of pin number
	public abstract int getChances();

	// to reset the pin number chances by bank operator
	public abstract void resetPinChances();

	// to generate MINI statement
	public abstract void generateMiniStatement();
}
