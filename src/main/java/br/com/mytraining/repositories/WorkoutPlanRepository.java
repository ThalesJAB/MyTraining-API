package br.com.mytraining.repositories;

import br.com.mytraining.entities.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long>{

    @Query("SELECT w FROM WorkoutPlan w WHERE w.person.id = :idPerson")
    List<WorkoutPlan> findAllWorkoutPlanByIdPerson(@Param(value="idPerson") Long idPerson);


}
