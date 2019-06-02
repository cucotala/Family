package com.example.Family.v2.controllers;

import com.example.Family.v2.exceptions.EntityNotFoundException;
import com.example.Family.v2.exceptions.IdRequiredException;
import com.example.Family.v2.exceptions.IllegalOperationException;
import com.example.Family.v2.models.PersonModel;
import com.example.Family.v2.services.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {


	private  final PersonServices personServices;

	public PersonController(PersonServices personServices) {
		this.personServices = personServices;
	}

	@GetMapping("/people")
	public List<PersonModel> findAll(){

		return personServices.findAll();

	}

	@GetMapping("/people/{id}")
	public PersonModel findOne(@PathVariable long id) throws EntityNotFoundException {

		return personServices.findOne(id);
	}


	@DeleteMapping("/people/{id}")
	public void delete(@PathVariable long id) throws EntityNotFoundException{

		personServices.delete(id);
	}


	@PostMapping("/people")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonModel save (@Valid @RequestBody PersonModel personModel)throws EntityNotFoundException{

		return personServices.save(personModel);
	}

	@PutMapping("/people/{id}")
	public PersonModel update(@PathVariable long id, @Valid @RequestBody PersonModel personModel ) throws EntityNotFoundException, IdRequiredException, IllegalOperationException {

		return personServices.update(id,personModel);
	}
}
