package br.com.mytraining.entities;

import br.com.mytraining.entities.enums.ProfileType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String name;

    @NotBlank
    @Length(min = 3, max = 100, message = "O campo E-MAIL deve ter entre 3 e 100 caracteres")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Length(min = 3, max = 100, message = "O campo SENHA deve ter entre 3 e 100 caracteres")
    private String password;

    @Max(130)
    private Integer age;
    private Double weight;
    private Double height;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PROFILES")
    private Set<Integer> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate = LocalDate.now();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<WorkoutPlan> workoutPlans = new TreeSet<>();

    public Person() {

    }

    public Person(Long id, String name, String email, String password, Integer age, Double weight, Double height, Set<ProfileType> profiles, Set<WorkoutPlan> workoutPlans) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        setProfiles(profiles);
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
        return profiles.stream().map(p -> ProfileType.valueOf(p)).collect(Collectors.toSet());
    }
    public void addProfile(ProfileType profile) {
        this.profiles.add(profile.getCode());
    }
    public void setProfiles(Set<ProfileType> profiles) {
        this.profiles = profiles.stream().map(p -> p.getCode()).collect(Collectors.toSet());
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Set<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    public void addWorkoutPlans(WorkoutPlan plan) {
        this.workoutPlans.add(plan);
    }

    public void setWorkoutPlans(Set<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return Objects.equals(id, other.id);
    }

}
