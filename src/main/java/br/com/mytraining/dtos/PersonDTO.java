package br.com.mytraining.dtos;

import java.io.Serializable;

import br.com.mytraining.entities.Person;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Integer age;
	private Double weight;
	private Double height;

	public PersonDTO() {

	}

	public PersonDTO(Person obj) {

		this.id = obj.getId();
		this.name = obj.getName();
		this.age = obj.getAge();
		this.weight = obj.getWeight();
		this.height = obj.getHeight();
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

}
