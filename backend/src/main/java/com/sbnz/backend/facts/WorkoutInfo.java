package com.sbnz.backend.facts;

import org.kie.api.definition.type.PropertyReactive;

import com.sbnz.backend.models.Workout;

import enums.WorkoutType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@PropertyReactive
public class WorkoutInfo {
	
	private WorkoutType muscleGroup;
	private int numberOfExercises;
	private int numberOfEasyExercises;
	private int numberOfHardExercises;
	private int restBetweenExercises;
	private int difficulty;
	
	// Strength workout info
	private int restBetweenSets;
	private int repetitions;
	private int numberOfSets;
	
	// Cardio workout info
	private int duration;
	private int numberOfRepetitions; // Broj ponavljanja sklopa vezbi
	private int exerciseDuration;
	
	public WorkoutInfo(Workout w) {
		this.muscleGroup = w.getMuscleGroup();
		this.difficulty = w.getDifficulty();
	}
	
	public WorkoutType getMuscleGroup() {
		return muscleGroup;
	}
	public void setMuscleGroup(WorkoutType muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
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
	public int getRepetitions() {
		return repetitions;
	}
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}
	public int getNumberOfSets() {
		return numberOfSets;
	}
	public void setNumberOfSets(int numberOfSets) {
		this.numberOfSets = numberOfSets;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNumberOfRepetitions() {
		return numberOfRepetitions;
	}
	public void setNumberOfRepetitions(int numberOfRepetitions) {
		this.numberOfRepetitions = numberOfRepetitions;
	}
	public int getExerciseDuration() {
		return exerciseDuration;
	}
	public void setExerciseDuration(int exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}

	public int getNumberOfExercises() {
		return numberOfExercises;
	}

	public void setNumberOfExercises(int numberOfExercises) {
		this.numberOfExercises = numberOfExercises;
	}

	public int getNumberOfEasyExercises() {
		return numberOfEasyExercises;
	}

	public void setNumberOfEasyExercises(int numberOfEasyExercises) {
		this.numberOfEasyExercises = numberOfEasyExercises;
	}

	public int getNumberOfHardExercises() {
		return numberOfHardExercises;
	}

	public void setNumberOfHardExercises(int numberOfHardExercises) {
		this.numberOfHardExercises = numberOfHardExercises;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	
	
}
