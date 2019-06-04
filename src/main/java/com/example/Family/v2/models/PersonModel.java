package com.example.Family.v2.models;

import com.example.Family.v2.entities.Person;
import com.example.Family.v2.repositories.PersonRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	private List<PersonModel> sons;

	private PersonModel dad;

	//private long dadIdModel;



	public static PersonModel from(Person person){

		PersonModel personModel = new PersonModel();
		personModel.setId(person.getId());
		personModel.setName(person.getName());
		personModel.setLastName(person.getLastName());
		personModel.setAge(person.getAge());
		personModel.setCountry(person.getCountry());
		//personModel.setDadMo(PersonModel.from(person.getDad()));
		//personModel.setDadId(person.getDad().getId());
		//personModel.setSons(person.getSons().stream().map(PersonModel::from).collect(Collectors.toList()));

		//personModel.setSons(PersonRepository.find);
		//personModel.setSons(PersonRepository.find);


/*
		if (person.getDad() != null){

			personModel.setDadId(person.getDad().getId());
			//personModel.setDad(PersonModel.from(person.getDad()));
			//no se ponde el Person dad porque no queremos que apareza el padre al realizar la consulta
		}

*/

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

	public List<PersonModel> getSons() {
		return sons;
	}

	public void setSons(List<PersonModel> sons) {
		this.sons = sons;
	}


	public PersonModel getDad() {
		return dad;
	}

	public void setDad(PersonModel dad) {
		this.dad = dad;
	}




}
