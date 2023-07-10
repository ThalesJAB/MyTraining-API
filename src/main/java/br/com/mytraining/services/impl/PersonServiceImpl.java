package br.com.mytraining.services.impl;

import br.com.mytraining.dtos.PersonDTO;
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

/*	@Autowired
	private BCryptPasswordEncoder encoder;*/

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
	public Person create(PersonDTO obj) {

		validateEmail(obj.getId(), obj.getEmail());

		String encryptedPassword = new BCryptPasswordEncoder().encode(obj.getPassword());

		Person newPerson = new Person();
		newPerson.setName(obj.getName());
		newPerson.setAge(obj.getAge());
		newPerson.setPassword(encryptedPassword);
		newPerson.setHeight(obj.getHeight());
		newPerson.setWeight(obj.getWeight());
		newPerson.setEmail(obj.getEmail());
		newPerson.setProfiles(obj.getProfiles());
		newPerson.setPassword(encryptedPassword);

		return repository.save(newPerson);
	}


	@Override
	public Person update(Long id, Person obj) {

		Person entity = findById(id);

		validateEmail(id, obj.getEmail());
		entity.setEmail(obj.getEmail());
		if(!obj.getPassword().equals(entity.getPassword())) {
			entity.setPassword(new BCryptPasswordEncoder().encode(obj.getPassword()));
		}
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
		findById(id);
		repository.deleteById(id);

	}


	private void validateEmail(Long id, String email) {
		Person personDB = repository.findByEmail(email);

		if(personDB != null) {

			if (personDB.getEmail().equals(email) && !personDB.getId().equals(id)) {
				throw new DataIntegrityViolationException("E-mail já cadastrado!");
			}
		}

	}



}
