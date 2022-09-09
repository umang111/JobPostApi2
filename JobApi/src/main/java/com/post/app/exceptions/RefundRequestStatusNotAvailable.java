package com.post.app.exceptions;

public class RefundRequestStatusNotAvailable extends Throwable {

	public RefundRequestStatusNotAvailable(String message) {
		super(message);
	}
	
	public RefundRequestStatusNotAvailable(String message, Throwable rootCause) {
		super(message, rootCause);
	}
}
