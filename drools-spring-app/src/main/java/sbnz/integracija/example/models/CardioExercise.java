package sbnz.integracija.example.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CardioExercise {
	private int exerciseDuration;

	
	public int getExerciseDuration() {
		return exerciseDuration;
	}

	public void setExerciseDuration(int exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}
	
}
