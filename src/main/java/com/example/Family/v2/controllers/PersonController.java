package com.example.Family.v2.controllers;

import com.example.Family.v2.entitties.Person;
import com.example.Family.v2.services.PersonServices;
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
	public List<Person> findAll(){

		return personServices.findAll();

	}

	@GetMapping("/people/{id}")
	public Person findOne(@PathVariable Long id){

		return personServices.findOne(id);
	}


	@DeleteMapping("/people/{id}")
	public void delete(@PathVariable long id){

		personServices.delete(id);
	}


	@PostMapping("/people")
	public Person save (@RequestBody Person person){

		return personServices.save(person);
	}

	@PutMapping("/people/{id}")
	public Person save(@Valid @RequestBody Person person, @PathVariable long id){

		return personServices.update(person, id);
	}
}
