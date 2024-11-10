package com.codegnan.cards;

import com.codegnan.customExceptions.InsufficentMachineBalanceException;
import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InvaildAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;

public class OperatorCard implements IATMService{
	
	
		private int pinNumber;
		private long id;
		private String name;
		private final String type="operator";
		public OperatorCard(long id,int pin, String name) {
			id=id;
			pinNumber=pin;
			this.name=name;
		}


		@Override
		public String getUserType() throws NotAOperatorException {
			
			return type;
		}

		@Override
		public double withdrawAmount(double wthAmount)
				throws InvaildAmountException, InsufficientBalanceException, InsufficentMachineBalanceException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void depositAmount(double deptAmount) throws InvaildAmountException {
			
		}

		@Override
		public double checkAccountBalance() {
			return 0;
		}

		@Override
		public void changePinNumber(int pinNumber) {
			
		}

		@Override
		public int getPinNumber() {
			// TODO Auto-generated method stub
			return pinNumber;
		}

		@Override
		public String getUserName() {
			return name;
		}

		@Override
		public void decreaseChances() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getChances() {
			return 0;
		}

		@Override
		public void resetPinChances() {
			
		}

		@Override
		public void generateMiniStatement() {
			
		}

	}

