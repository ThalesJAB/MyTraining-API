package br.com.mytraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mytraining.entities.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long>{

}
