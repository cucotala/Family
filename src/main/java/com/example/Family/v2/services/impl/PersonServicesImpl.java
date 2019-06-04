package com.example.Family.v2.services.impl;

import com.example.Family.v2.entities.Person;
import com.example.Family.v2.exceptions.EntityNotFoundException;
import com.example.Family.v2.exceptions.IdRequiredException;
import com.example.Family.v2.exceptions.IllegalOperationException;
import com.example.Family.v2.models.PersonModel;
import com.example.Family.v2.repositories.PersonRepository;
import com.example.Family.v2.services.PersonServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServicesImpl implements PersonServices {

	private final PersonRepository personRepository;

	public PersonServicesImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<PersonModel> findAll() {

		return personRepository.findAll()
							   .stream()
							   .map(PersonModel::from)
							   .collect(Collectors.toList());

	}

	@Override
	public void delete(long id) throws EntityNotFoundException{
		Person person = personRepository.findById(id).orElseThrow(()->new EntityNotFoundException(Person.class, id));

		personRepository.delete(person);


	}



	@Override
	public PersonModel save(PersonModel personModel) throws EntityNotFoundException, IdRequiredException{


		long idDadModel = personModel.getId().orElseThrow(IdRequiredException::new);


		Person person = new Person();
		person.setName(personModel.getName());
		person.setLastname(personModel.getLastName());
		person.setAge(personModel.getAge());
		person.setCountry(personModel.getCountry());
		//person.setDadId(idDadModel);
		//person.setDad(personRepository.findById(idDadModel).get());
		//person.setSons(personRepository.findAll()
									//   .stream()
									 //  .filter(p-> p.getDad().getId()==idDadModel)
									 //  .collect(Collectors.toList()));
		/*
		person.setSons(personRepository.findAll()
									   .stream()
									   .filter(p-> p.getDad().getId()==person.getId()).collect(Collectors.toList()));*/

		if (personModel.getDad() != null){

			personRepository.findById(idDadModel).get().getSons().add(person);
		}


		//if (personRepository.findById(idDadModel).isPresent()){

			//personRepository.findById(idDadModel).get().getSons().add(person);

		//}

		return PersonModel.from(personRepository.save(person));




	}


	@Override
	public PersonModel update(long id, PersonModel personModel) throws EntityNotFoundException, IdRequiredException, IllegalOperationException {

		long modelId = personModel.getId().orElseThrow(IdRequiredException::new);
		long idDadModel = personModel.getId().orElseThrow(IdRequiredException::new);

		if (id != modelId)
			throw new IllegalOperationException("IDs doesn't match");


		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));

		person.setName(personModel.getName());
		person.setLastname(personModel.getLastName());
		person.setAge(personModel.getAge());
		person.setCountry(personModel.getCountry());
		person.setDad(personRepository.findById(idDadModel).orElseThrow(()-> new EntityNotFoundException(Person.class, idDadModel)));
		/*person.setSons(personRepository.findAll()
									   .stream()
									   .filter(p-> p.getDad().getId()==person.getId())
									   .collect(Collectors.toList())); */

		personRepository.findById(idDadModel).get().getSons().add(person);


		return PersonModel.from(personRepository.save(person));

	}


	@Override
	public PersonModel findOne(long id) throws EntityNotFoundException {

		return personRepository.findById(id)
							   .map(PersonModel::from)
							   .orElseThrow(()-> new EntityNotFoundException(Person.class, id));

	}




}
