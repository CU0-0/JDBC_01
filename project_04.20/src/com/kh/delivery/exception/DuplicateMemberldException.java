package com.kh.delivery.exception;

public class DuplicateMemberldException extends RuntimeException {

	public DuplicateMemberldException() {
	}

	public DuplicateMemberldException(String message) {
		super(message);
	}

	public DuplicateMemberldException(Throwable cause) {
		super(cause);
	}

	public DuplicateMemberldException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateMemberldException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
