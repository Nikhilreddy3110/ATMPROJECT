package com.codegnan.customExceptions;

public class InvaildAmountException extends Exception {
   public InvaildAmountException(String errorMsg) {
	   super(errorMsg);
   }
}
