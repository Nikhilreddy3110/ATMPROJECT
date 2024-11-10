package com.codegnan.customExceptions;

public class InvaildPinException extends Exception {
   public InvaildPinException(String errorMsg) {
	   super(errorMsg);
   }
}
