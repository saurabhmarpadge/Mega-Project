package com.megaproject.exception;

public class ClientSideException extends RuntimeException {
	private static final long serialVersionUID = 852339594390901245L;

	public ClientSideException(String message) {
		super(message);
	}
}
