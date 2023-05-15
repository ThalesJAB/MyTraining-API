package br.com.mytraining.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mytraining.entities.Person;
import br.com.mytraining.repositories.PersonRepository;
import br.com.mytraining.services.PersonService;
import br.com.mytraining.services.exceptions.ObjectNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;

	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

	@Override
	public Person findById(Long id) {

		Optional<Person> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Person.class.getName()));
	}

	@Override
	public Person create(Person obj) {
		return repository.save(obj);
	}

	@Override
	public Person update(Long id, Person obj) {

		Person entity = findById(id);

		entity.setAge(obj.getAge());
		entity.setHeight(obj.getHeight());
		entity.setName(obj.getName());
		entity.setWeight(obj.getWeight());

		if (obj.getWorkoutPlans() != null) {
			entity.setWorkoutPlans(obj.getWorkoutPlans());
		}

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

}
