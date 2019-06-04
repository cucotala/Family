package com.example.Family.v2.services;

import com.example.Family.v2.exceptions.EntityNotFoundException;
import com.example.Family.v2.exceptions.IdRequiredException;
import com.example.Family.v2.exceptions.IllegalOperationException;
import com.example.Family.v2.models.PersonModel;

import java.util.List;

public interface PersonServices {


	List<PersonModel> findAll();

	PersonModel findOne(long id) throws EntityNotFoundException;

	void  delete(long id) throws EntityNotFoundException;

	public PersonModel save(PersonModel personModel) throws EntityNotFoundException, IdRequiredException;

	public PersonModel update(Long id, PersonModel personModel) throws EntityNotFoundException, IdRequiredException, IllegalOperationException;

	interface CustomUserDetailsService {


	}
}
