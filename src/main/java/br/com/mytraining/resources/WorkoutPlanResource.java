package br.com.mytraining.resources;

import br.com.mytraining.entities.WorkoutPlan;
import br.com.mytraining.services.WorkoutPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/persons/{idPerson}/workoutplans")
public class WorkoutPlanResource {

	@Autowired
	private WorkoutPlanService service;

	@GetMapping
	public ResponseEntity<List<WorkoutPlan>> findAllWorkoutPlanByIdPerson(@PathVariable Long idPerson) {

		List<WorkoutPlan> workoutPlanList = service.findAllWorkoutPlanByIdPerson(idPerson);

		return ResponseEntity.ok().body(workoutPlanList);

	}

	@GetMapping(value = "/{idWorkoutPlan}")
	public ResponseEntity<WorkoutPlan> findById(@PathVariable Long idPerson, @PathVariable Long idWorkoutPlan) {

		WorkoutPlan obj = service.findById(idPerson, idWorkoutPlan);

		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<WorkoutPlan> create(@PathVariable Long idPerson, @Valid @RequestBody WorkoutPlan obj) {

		obj = service.create(idPerson, obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/persons/{idPerson}/workoutplans/{id}").buildAndExpand(idPerson, obj.getId()).toUri();;

		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{idWorkoutPlan}")
	public ResponseEntity<WorkoutPlan> update(@PathVariable Long idPerson, @PathVariable Long idWorkoutPlan, @Valid @RequestBody WorkoutPlan obj) {

		obj = service.update(idPerson, idWorkoutPlan, obj);

		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{idWorkoutPlan}")
	public ResponseEntity<Void> delete(@PathVariable Long idPerson, @PathVariable Long idWorkoutPlan){
		
		service.delete(idPerson, idWorkoutPlan);
		
		return ResponseEntity.noContent().build();
		
	}

}
