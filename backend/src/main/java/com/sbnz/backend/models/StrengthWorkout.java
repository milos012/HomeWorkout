package com.sbnz.backend.models;

import java.util.ArrayList;

import enums.WorkoutType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class StrengthWorkout extends Workout{
	
	private int restBetweenSets;
	private int restBetweenExercises;
	private ArrayList<Exercise> exercises;

	public int getRestBetweenSets() {
		return restBetweenSets;
	}

	public void setRestBetweenSets(int restBetweenSets) {
		this.restBetweenSets = restBetweenSets;
	}

	public int getRestBetweenExercises() {
		return restBetweenExercises;
	}

	public void setRestBetweenExercises(int restBetweenExercises) {
		this.restBetweenExercises = restBetweenExercises;
	}

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	public StrengthWorkout(Long id, int difficulty, WorkoutType muscleGroup) {
		super(id, difficulty, muscleGroup);
	}
	
	

}
