package com.example.Family.v2.exceptions;

import com.example.Family.v2.exceptions.generic.ConflictException;

public class DuplicatedEntityException extends ConflictException {

	public DuplicatedEntityException() {
		super("Duplicated entity");
	}
}
