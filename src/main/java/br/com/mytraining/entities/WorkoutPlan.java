package br.com.mytraining.entities;

import br.com.mytraining.dtos.PersonDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class WorkoutPlan implements Serializable, Comparable<WorkoutPlan> {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate finishDate;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="workout_plan_id")
	private List<Workout> workoutsList = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public WorkoutPlan() {

	}

	public WorkoutPlan(Long id, String title, String description, LocalDate startDate, LocalDate finishDate,
					   List<Workout> workoutsList, Person person) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.workoutsList = workoutsList;
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public List<Workout> getWorkoutsList() {
		return workoutsList;
	}

	public void setWorkoutsList(List<Workout> workoutsList) {
		this.workoutsList = workoutsList;
	}

	public PersonDTO getPerson() {
		return new PersonDTO(person);
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkoutPlan other = (WorkoutPlan) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public int compareTo(WorkoutPlan wp) {
		return Long.compare(this.id, wp.getId());
	}
}
