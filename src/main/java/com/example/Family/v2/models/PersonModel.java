package com.example.Family.v2.models;

import com.example.Family.v2.entities.Person;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class PersonModel {

	private Long id;



	@NotNull
	private String name;

	@NotNull
	private String lastName;

	@NotNull
	private int age;

	@NotNull
	private String country;


	public static PersonModel from(Person person){
		PersonModel personModel = new PersonModel();
		personModel.setId(person.getId());
		personModel.setName(person.getName());
		personModel.setLastName(person.getLastName());
		personModel.setAge(person.getAge());
		personModel.setCountry(person.getCountry());

		return personModel;


	}

	public Optional<Long> getId(){
		return Optional.ofNullable(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
