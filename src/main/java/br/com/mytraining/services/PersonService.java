package br.com.mytraining.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mytraining.entities.Person;
import br.com.mytraining.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;

	public List<Person> findAll() {
		
		return repository.findAll();
		
	}

	public Person findById(Long id) {

		Optional<Person> obj = repository.findById(id);

		return obj.orElse(null);
	}

	public Person create(Person obj) {
		return repository.save(obj);
	}

	public Person update(Long id, Person obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
		
	}

}
