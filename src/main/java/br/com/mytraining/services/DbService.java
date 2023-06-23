package br.com.mytraining.services;

import br.com.mytraining.entities.Exercise;
import br.com.mytraining.entities.Person;
import br.com.mytraining.entities.Workout;
import br.com.mytraining.entities.WorkoutPlan;
import br.com.mytraining.entities.enums.ProfileType;
import br.com.mytraining.entities.enums.TrainingType;
import br.com.mytraining.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

@Service
public class DbService {


    @Autowired
    private PersonRepository personRepository;


    public void initBd() {

        Person person1 = new Person(null, "Thales", "thalesjoseaguiar@gmail.com", "12345", 22, 90.1, 1.77, Set.of(ProfileType.PERSON, ProfileType.ADMIN), null);
        Person person2 = new Person(null, "Maria", "maria@gmail.com", "12345", 25, 60.2, 1.60, Set.of(ProfileType.PERSON), null);
        Person person3 = new Person(null, "Pedro", "pedro@hotmail.com", "12345", 40, 90.0, 1.80, Set.of(ProfileType.PERSONAL_TRAINER),null);
        Person person4 = new Person(null, "João", "joao@gmail.com", "12345", 30, 80.5, 1.75, Set.of(ProfileType.PERSON), null);

        // Creating exercises

        // Costas
        Exercise exercise1 = new Exercise(null, "Barra fixa", "Barra fixa com pegada aberta", 5, 3, "2 minutos de descanso");
        Exercise exercise2 = new Exercise(null, "Remada alta", "Remada alta com barra", 10, 3, "2 minutos de descanso");
        Exercise exercise3 = new Exercise(null, "Remada curvada", "Remada curvada com barra", 12, 4, "1 minuto de descanso");

        // Peito
        Exercise exercise4 = new Exercise(null, "Supino reto", "Supino reto com halteres", 8, 4, "30 segundos de descanso");
        Exercise exercise5 = new Exercise(null, "Flexão de braço", "Flexão de braço no chão", 15, 3, "1 minuto de descanso");

        // Pernas
        Exercise exercise6 = new Exercise(null, "Agachamento", "Agachamento com barra nas costas", 10, 3, "1 minuto de descanso");
        Exercise exercise7 = new Exercise(null, "Agachamento com salto", "Agachamento com salto para fortalecer as pernas", 12, 4, "30 segundos de descanso");
        Exercise exercise8 = new Exercise(null, "Agachamento sumô", "Agachamento com os pés afastados", 8, 4, "1 minuto de descanso");

        // Ombros
        Exercise exercise9 = new Exercise(null, "Desenvolvimento", "Desenvolvimento com barra", 8, 3, "2 minutos de descanso");
        Exercise exercise10 = new Exercise(null, "Elevação lateral", "Elevação lateral com halteres", 12, 3, "30 segundos de descanso");

        // Bíceps
        Exercise exercise11 = new Exercise(null, "Rosca direta", "Rosca direta com barra", 8, 3, "1 minuto de descanso");
        Exercise exercise12 = new Exercise(null, "Rosca martelo", "Rosca martelo com halteres", 12, 3, "30 segundos de descanso");
        Exercise exercise13 = new Exercise(null, "Rosca concentrada", "Rosca concentrada com halteres", 10, 4, "1 minuto de descanso");

        // Tríceps
        Exercise exercise14 = new Exercise(null, "Tríceps pulley", "Tríceps pulley com corda", 12, 3, "30 segundos de descanso");
        Exercise exercise15 = new Exercise(null, "Tríceps francês", "Tríceps francês com halteres", 10, 4, "1 minuto de descanso");
        Exercise exercise16 = new Exercise(null, "Tríceps testa", "Tríceps testa com barra", 8, 3, "2 minutos de descanso");


        //Peito e triceps

        Workout workout1 = new Workout(null, "Peito e Tríceps", "Treino de força", TrainingType.A, Arrays.asList(exercise4, exercise5, exercise14, exercise15, exercise16));


        //Costas e Biceps

        Workout workout2 = new Workout(null, "Costas e Bíceps", "Treino de força, aumento de carga, melhorar amplitude", TrainingType.B, Arrays.asList(exercise1, exercise2, exercise3, exercise11, exercise12, exercise13));


        //Ombros

        Workout workout3 = new Workout(null, "Ombros", "Treino de força", TrainingType.C, Arrays.asList(exercise9, exercise10));


        // Pernas

        Workout workout4 = new Workout(null, "Quadríceps e posterior", "Treino de força, melhorar amplitude do movimento", TrainingType.D, Arrays.asList(exercise6, exercise7, exercise8));


        // Criando um plano de treino

        WorkoutPlan workoutPlan1 = new WorkoutPlan(null, "Treino Thales Abril", "Voltado para ganho de força e hipertrofia", LocalDate.now(), LocalDate.of(2023, 4, 3), Arrays.asList(workout1, workout2, workout3, workout4), person1);

        person1.setWorkoutPlans(Arrays.asList(workoutPlan1));

        personRepository.saveAll(Arrays.asList(person1, person2, person3, person4));


    }

}
