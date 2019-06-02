package com.example.Family.v2.services;

import com.example.Family.v2.entitties.Person;

import java.util.List;

public interface PersonServices {


	List<Person> findAll();

	Person findOne(long id);

	void  delete(long id);

	public Person save(Person person);

	public Person update(Person person, long id);





}
