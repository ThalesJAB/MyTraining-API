package br.com.mytraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mytraining.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    Person findByEmail(String email);

}
