package com.example.Family.v2.exceptions;

import com.example.Family.v2.exceptions.generic.NotFoundException;

public class EntityNotFoundException extends NotFoundException {

	public EntityNotFoundException(Class clazz) {
		super(clazz.getSimpleName() + " not found with");
	}

	public EntityNotFoundException(Class clazz, long id) {
		super(clazz.getSimpleName() + " not found with id " + id);
	}

}
