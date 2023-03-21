package br.com.mytraining.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class WorkoutPlan {
	private Long id;
	private String title;
	private String description;
	private LocalDateTime startDate;
	private LocalDateTime finishDate;

	private Person person;

	public WorkoutPlan() {

	}

	public WorkoutPlan(Long id, String title, String description, LocalDateTime startDate, LocalDateTime finishDate,
			Person person) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
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
