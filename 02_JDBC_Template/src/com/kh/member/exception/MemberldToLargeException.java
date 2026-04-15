package com.kh.member.exception;

public class MemberldToLargeException extends RuntimeException {

	public MemberldToLargeException() {
	}

	public MemberldToLargeException(String message) {
		super(message);
	}

	public MemberldToLargeException(Throwable cause) {
		super(cause);
	}

	public MemberldToLargeException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemberldToLargeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
