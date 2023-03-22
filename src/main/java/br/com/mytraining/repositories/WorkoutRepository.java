package br.com.mytraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mytraining.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{

}
