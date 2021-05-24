package com.sbnz.backend.models;

import enums.WorkoutType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class Workout {
	private Long id;
	private int difficulty;
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
