package br.com.mytraining.dtos;

import br.com.mytraining.entities.Person;
import br.com.mytraining.entities.enums.ProfileType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	private Long id;
	private String name;
	private String email;
	private String password;
	private Integer age;
	private Double weight;
	private Double height;

	private Set<Integer> profiles = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate creationDate = LocalDate.now();

	public PersonDTO() {

	}

	public PersonDTO(Person obj) {

		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.age = obj.getAge();
		this.weight = obj.getWeight();
		this.height = obj.getHeight();
		this.profiles = obj.getProfiles().stream().map(ProfileType::getCode).collect(Collectors.toSet());
		this.creationDate = obj.getCreationDate();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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


	public Set<ProfileType> getProfiles() {
		return profiles.stream().map(ProfileType::valueOf).collect(Collectors.toSet());
	}

	public void addProfile(ProfileType profileType){
		this.profiles.add(profileType.getCode());

	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

}
