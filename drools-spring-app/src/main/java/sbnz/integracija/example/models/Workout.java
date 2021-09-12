package sbnz.integracija.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sbnz.integracija.example.enums.WorkoutType;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workout")
public class Workout {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "difficulty")
	private int difficulty;
	
	@Column(name = "muscleGroup")
	private WorkoutType muscleGroup;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public Workout(Long id) {
		super();
		this.id = id;
	}
	public WorkoutType getMuscleGroup() {
		return muscleGroup;
	}
	
	public void setMuscleGroup(WorkoutType muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	
}
