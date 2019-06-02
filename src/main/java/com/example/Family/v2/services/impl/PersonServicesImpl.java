package com.example.Family.v2.services.impl;

import com.example.Family.v2.entitties.Person;
import com.example.Family.v2.repositories.PersonRepository;
import com.example.Family.v2.services.PersonServices;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServicesImpl implements PersonServices {

	private final PersonRepository personRepository;

	public PersonServicesImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> findAll() {

		return personRepository.findAll();

	}

	@Override
	public void delete(long id) {

		personRepository.deleteById(id);

	}
	/*
	@Override
	public Person save(Person person) {
		List<Person>sons = personRepository.findAll()
										   .stream()
										   .filter(p-> p.getDad().getId()==person.getId())
										   .collect(Collectors.toList());



		Person newPerson = new Person();

		newPerson.setName(person.getName());
		newPerson.setDad(person.getDad());
		//newPerson.setSons(sons);
		person.setSons(sons);


		return personRepository.save(newPerson);

	}*/


	@Override
	public Person save(Person person){
		Person newPerson = new Person();

		newPerson.setName(person.getName());
		newPerson.setSons(newPerson.getSons());

		return personRepository.save(newPerson);


	}


	@Override
	public Person update(Person person, long id){
		Person newPerson = personRepository.findById(id).get();

		newPerson.setName(person.getName());
		newPerson.setSons(person.getSons());

		return personRepository.save(newPerson);


	}


	@Override
	public Person findOne(long id) {

		return personRepository.findById(id).get();

	}




}
