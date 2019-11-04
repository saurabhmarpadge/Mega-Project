package com.megaproject.exception;

public class ServerSideException extends RuntimeException {
	private static final long serialVersionUID = 7894560118213418L;

	public ServerSideException(String message) {
		super(message);
	}
}
