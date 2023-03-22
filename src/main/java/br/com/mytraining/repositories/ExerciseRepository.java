package br.com.mytraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mytraining.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
