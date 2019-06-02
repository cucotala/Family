/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.example.Family.v2.exceptions.generic;

public class BadRequestException extends Exception {

	protected BadRequestException() {
	}

	protected BadRequestException(String message) {
		super(message);
	}

}
