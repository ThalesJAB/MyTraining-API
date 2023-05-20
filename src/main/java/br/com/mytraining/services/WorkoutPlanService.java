package br.com.mytraining.services;

import br.com.mytraining.entities.WorkoutPlan;

import java.util.List;

public interface WorkoutPlanService {

	List<WorkoutPlan> findAllWorkoutPlanByIdPerson(Long idPerson);

	WorkoutPlan findById(Long idPerson, Long idWorkoutPlan);

	WorkoutPlan create(Long idPerson, WorkoutPlan obj);

	WorkoutPlan update(Long idPerson, Long idWorkoutPlan, WorkoutPlan obj);

	void delete(Long idPerson, Long idWorkoutPlan);


}
