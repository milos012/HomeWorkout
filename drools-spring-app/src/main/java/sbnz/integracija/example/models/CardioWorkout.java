package sbnz.integracija.example.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sbnz.integracija.example.enums.WorkoutType;

@NoArgsConstructor
@AllArgsConstructor
public class CardioWorkout extends Workout{
	
	private int duration; // Duzina treninga
	private int restBetweenExercises;
	private int numberOfRepetitions; // Broj ponavljanja vezbi
	private ArrayList<Exercise> exercises;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRestBetweenExercises() {
		return restBetweenExercises;
	}

	public void setRestBetweenExercises(int restBetweenExercises) {
		this.restBetweenExercises = restBetweenExercises;
	}

	public int getNumberOfRepetitions() {
		return numberOfRepetitions;
	}

	public void setNumberOfRepetitions(int numberOfRepetitions) {
		this.numberOfRepetitions = numberOfRepetitions;
	}

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	public CardioWorkout(Long id, int duration, int restBetweenExercises, int numberOfRepetitions,
			ArrayList<Exercise> exercises) {
		super(id);
		this.duration = duration;
		this.restBetweenExercises = restBetweenExercises;
		this.numberOfRepetitions = numberOfRepetitions;
		this.exercises = exercises;
	}

	public CardioWorkout(Long id, int difficulty, WorkoutType muscleGroup, int duration, int restBetweenExercises,
			int numberOfRepetitions, ArrayList<Exercise> exercises) {
		super(id, difficulty, muscleGroup);
		this.duration = duration;
		this.restBetweenExercises = restBetweenExercises;
		this.numberOfRepetitions = numberOfRepetitions;
		this.exercises = exercises;
	}
	
	
	
	
}
