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
	public void delete(long id) throws EntityNotFoundException {
		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));

		//hago esto para poder borrar a gente con hijos
		if (person.getSons() != null)
			person.getSons()
				  .stream().filter(p -> p.getDad().getId() == id)
				  .forEach(person1 -> person1.setDad(null));

		/* Asi no me deja
		if (personRepository.findById(id).get().getSons()!= null) {
			personRepository.findById(id).get().setSons(null);
		}
		*/

		//solo con esto no me deja borrar a alguien que tiene hijos
		personRepository.delete(person);

	}

	@Override
	public PersonModel save(PersonModel personModel) throws EntityNotFoundException {
		Person person = new Person();
		person.setName(personModel.getName());
		person.setLastname(personModel.getLastName());
		person.setAge(personModel.getAge());
		person.setCountry(personModel.getCountry());

		if (personModel.getDadId().isPresent()) {
			person.setDad(personRepository.findById(personModel.getDadId().get())
										  .orElseThrow(() -> new EntityNotFoundException(Person.class)));
		}
	//prueba
		return PersonModel.from(personRepository.save(person));
	}

	@Override
	public PersonModel update(Long id, PersonModel personModel) throws EntityNotFoundException, IdRequiredException, IllegalOperationException {
		long modelId = personModel.getId().orElseThrow(IdRequiredException::new);

		if (id != modelId)
			throw new IllegalOperationException("IDs doesn't match");

		Person person = personRepository.findById(id)
										.orElseThrow(() -> new EntityNotFoundException(Person.class, id));

		person.setName(personModel.getName());
		person.setLastName(personModel.getLastName());
		person.setAge(personModel.getAge());
		person.setCountry(personModel.getCountry());

		if (personModel.getDadId().isPresent()) {
			person.setDad(personRepository.findById(personModel.getDadId().get())
										  .orElseThrow(() -> new EntityNotFoundException(Person.class)));
		}else{
			person.setDad(null);
		}


		return PersonModel.from(personRepository.save(person));

	}

	@Override
	public PersonModel findOne(long id) throws EntityNotFoundException {

		return personRepository.findById(id)
							   .map(PersonModel::from)
							   .orElseThrow(() -> new EntityNotFoundException(Person.class, id));

	}

}
