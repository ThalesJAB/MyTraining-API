package br.com.mytraining.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

	private Long id;
	private String name;
	private Double weight;
	private Double height;
	private List<WorkoutPlan> workoutPlans = new ArrayList<>();

	public Person() {

	}

	public Person(Long id, String name, Double weight, Double height, List<WorkoutPlan> workoutPlans) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.workoutPlans = workoutPlans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public List<WorkoutPlan> getWorkoutPlans() {
		return workoutPlans;
	}

	public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
		this.workoutPlans = workoutPlans;
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
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}

}
