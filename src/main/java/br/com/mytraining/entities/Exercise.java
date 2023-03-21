package br.com.mytraining.entities;

import java.util.Objects;

public class Exercise {

	private Long id;
	private String name;
	private String description;
	private Integer reps;
	private Integer sets;
	private String rets;

	public Exercise() {

	}

	public Exercise(Long id, String name, String description, Integer reps, Integer sets, String rets) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.reps = reps;
		this.sets = sets;
		this.rets = rets;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public Integer getSets() {
		return sets;
	}

	public void setSets(Integer sets) {
		this.sets = sets;
	}

	public String getRets() {
		return rets;
	}

	public void setRets(String rets) {
		this.rets = rets;
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
		Exercise other = (Exercise) obj;
		return Objects.equals(id, other.id);
	}

}
