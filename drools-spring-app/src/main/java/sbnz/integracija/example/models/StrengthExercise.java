package sbnz.integracija.example.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class StrengthExercise extends Exercise{
	
	private int repetitions;
	private int numberOfSets;
	private double weights; // Tezina
	
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
	public double getWeights() {
		return weights;
	}
	public void setWeights(double weights) {
		this.weights = weights;
	}
	
	
}
