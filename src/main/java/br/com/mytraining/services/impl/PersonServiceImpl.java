package br.com.mytraining.services.impl;

import br.com.mytraining.entities.Person;
import br.com.mytraining.repositories.PersonRepository;
import br.com.mytraining.services.PersonService;
import br.com.mytraining.services.exceptions.DataIntegrityViolationException;
import br.com.mytraining.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;

	private BCryptPasswordEncoder encoder;

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
		validateEmail(obj);

		obj.setPassword(encoder.encode(obj.getPassword()));

		return repository.save(obj);
	}


	@Override
	public Person update(Long id, Person obj) {

		Person entity = findById(id);

		validateEmail(obj);
		entity.setEmail(obj.getEmail());
		if(!obj.getPassword().equals(entity.getPassword())) {
			entity.setPassword(encoder.encode(obj.getPassword()));
		}
		entity.setPassword(obj.getPassword());
		entity.setAge(obj.getAge());
		entity.setHeight(obj.getHeight());
		entity.setName(obj.getName());
		entity.setWeight(obj.getWeight());
		obj.getWorkoutPlans().forEach(entity::addWorkoutPlans);
		obj.getProfiles().forEach(entity::addProfile);


		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}


	private void validateEmail(Person obj) {
		Optional<Person> personDB = repository.findByEmail(obj.getEmail());

		if(personDB.isPresent() && !personDB.get().getId().equals(obj.getId())){
			throw new DataIntegrityViolationException("E-mail já cadastrado!");
		}

	}

}
