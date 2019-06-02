package com.example.Family.v2.exceptions;

import com.example.Family.v2.exceptions.generic.ConflictException;

public class IllegalOperationException extends ConflictException {

	public IllegalOperationException(String s) {
		super(s);
	}
}
