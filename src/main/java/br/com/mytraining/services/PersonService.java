package br.com.mytraining.services;

import br.com.mytraining.dtos.PersonDTO;
import br.com.mytraining.entities.Person;

import java.util.List;

public interface PersonService {

	List<Person> findAll();

	Person findById(Long id);

	Person create(PersonDTO obj);

	Person update(Long id, Person obj);

	void delete(Long id);

}
