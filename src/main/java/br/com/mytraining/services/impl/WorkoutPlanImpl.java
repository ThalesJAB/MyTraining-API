package br.com.mytraining.services.impl;

import br.com.mytraining.entities.Person;
import br.com.mytraining.entities.WorkoutPlan;
import br.com.mytraining.repositories.WorkoutPlanRepository;
import br.com.mytraining.services.PersonService;
import br.com.mytraining.services.WorkoutPlanService;
import br.com.mytraining.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutPlanImpl implements WorkoutPlanService {


    @Autowired
    private PersonService personService;

    @Autowired
    private WorkoutPlanRepository repository;


    @Override
    public List<WorkoutPlan> findAllWorkoutPlanByIdPerson(Long idPerson) {
        return repository.findAllWorkoutPlanByIdPerson(idPerson);

    }

    @Override
    public WorkoutPlan findById(Long idPerson, Long idWorkoutPlan) {

        personService.findById(idPerson);
        List<WorkoutPlan> list = findAllWorkoutPlanByIdPerson(idPerson);
        Optional<WorkoutPlan> workoutPlan = list.stream().filter(obj -> obj.getId().equals(idWorkoutPlan)).findFirst();

        return workoutPlan.orElseThrow(() -> new ObjectNotFoundException("Plano de treino não encontrado"));


    }

    @Override
    public WorkoutPlan create(Long idPerson, WorkoutPlan obj) {
        Person person = personService.findById(idPerson);

        obj.setPerson(person);

        obj = repository.save(obj);

        person.addWorkoutPlans(obj);

        personService.update(idPerson, person);


        return obj;
    }

    @Override
    public WorkoutPlan update(Long idPerson, Long idWorkoutPlan, WorkoutPlan obj) {
        Person person = personService.findById(idPerson);

        WorkoutPlan workoutPlan = person.getWorkoutPlans().stream().filter(w -> w.getId().equals(idWorkoutPlan)).findFirst().orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + idWorkoutPlan + ", Tipo: " + WorkoutPlan.class.getName()));


        workoutPlan.setDescription(obj.getDescription());
        workoutPlan.setWorkoutsList(obj.getWorkoutsList());
        workoutPlan.setTitle(obj.getTitle());
        workoutPlan.setStartDate(obj.getStartDate());
        workoutPlan.setFinishDate(obj.getFinishDate());

        return repository.save(workoutPlan);
    }

    @Override
    public void delete(Long idPerson, Long idWorkoutPlan) {
        Person person = personService.findById(idPerson);

        WorkoutPlan workoutPlan = person.getWorkoutPlans().stream().filter(w -> w.getId().equals(idWorkoutPlan)).findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + idWorkoutPlan + ", Tipo: " + WorkoutPlan.class.getName()));

        person.getWorkoutPlans().remove(workoutPlan);

        repository.deleteById(idWorkoutPlan);


    }

}
