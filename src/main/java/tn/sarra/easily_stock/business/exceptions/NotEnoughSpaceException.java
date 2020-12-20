package tn.sarra.easily_stock.business.exceptions;

public class NotEnoughSpaceException extends Exception {
	public NotEnoughSpaceException(String message) {
		super(message);
	}
}