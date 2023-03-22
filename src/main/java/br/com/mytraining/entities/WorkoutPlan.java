package br.com.mytraining.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class WorkoutPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private LocalDateTime startDate;
	private LocalDateTime finishDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="workout_plan_id")
	private List<Workout> workoutsList = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public WorkoutPlan() {

	}

	public WorkoutPlan(Long id, String title, String description, LocalDateTime startDate, LocalDateTime finishDate,
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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDateTime finishDate) {
		this.finishDate = finishDate;
	}

	public List<Workout> getWorkoutsList() {
		return workoutsList;
	}

	public void setWorkoutsList(List<Workout> workoutsList) {
		this.workoutsList = workoutsList;
	}

	public Person getPerson() {
		return person;
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
	
	

}
