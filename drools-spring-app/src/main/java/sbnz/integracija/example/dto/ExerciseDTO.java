package sbnz.integracija.example.dto;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sbnz.integracija.example.enums.Equipment;
import sbnz.integracija.example.enums.WorkoutType;
import sbnz.integracija.example.models.Exercise;

@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {
	
	
	private long id;
	private String name;
	private String description;
	private WorkoutType workoutType;
	private Equipment requiredEquipment;
	private int difficulty;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public WorkoutType getWorkoutType() {
		return workoutType;
	}
	public void setWorkoutType(WorkoutType workoutType) {
		this.workoutType = workoutType;
	}
	public Equipment getRequiredEquipment() {
		return requiredEquipment;
	}
	public void setRequiredEquipment(Equipment requiredEquipment) {
		this.requiredEquipment = requiredEquipment;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public ExerciseDTO(Exercise exercise) {
		this.id = exercise.getId();
		this.name = exercise.getName();
		this.description = exercise.getDescription();
		this.workoutType = exercise.getWorkoutType();
		this.requiredEquipment = exercise.getRequiredEquipment();
		this.difficulty = exercise.getDifficulty();
		
	}
	

}
