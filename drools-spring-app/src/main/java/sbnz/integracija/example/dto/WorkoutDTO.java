package sbnz.integracija.example.dto;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sbnz.integracija.example.enums.WorkoutType;
import sbnz.integracija.example.models.Workout;

@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDTO {
	
	private Long id;
	private int difficulty;
	private WorkoutType muscleGroup;
	
	public WorkoutDTO(int difficulty, WorkoutType muscleGroup) {
		this.difficulty = difficulty;
		this.muscleGroup = muscleGroup;
	}
	
	public WorkoutDTO(Workout wo) {
		this.id = wo.getId();
		this.difficulty = wo.getDifficulty();
		this.muscleGroup = wo.getMuscleGroup();
	}
	
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
	public WorkoutType getMuscleGroup() {
		return muscleGroup;
	}
	public void setMuscleGroup(WorkoutType muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	
	

}
