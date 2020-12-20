package tn.sarra.easily_stock.business.exceptions;

public class SameAddressException extends Exception{
	public SameAddressException(String message) {
		super(message);
	}
}