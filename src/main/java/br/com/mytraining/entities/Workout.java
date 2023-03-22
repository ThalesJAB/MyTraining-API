package br.com.mytraining.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.mytraining.entities.enums.TrainingType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Integer trainingType;
	
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
	private List<Exercise> exerciseList = new ArrayList<>();

	public Workout() {
	
	}

	public Workout(Long id, String name, String description, TrainingType trainingType, List<Exercise> exerciseList) {
		this.id = id;
		this.name = name;
		this.description = description;
		setTrainingType(trainingType);
		this.exerciseList = exerciseList;
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

	public TrainingType getTrainingType() {
		return TrainingType.valueOf(this.trainingType);
	}

	public void setTrainingType(TrainingType trainingType) {
		if(trainingType != null) {
			this.trainingType = trainingType.getCode();
		}
	}

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
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
		Workout other = (Workout) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
}
