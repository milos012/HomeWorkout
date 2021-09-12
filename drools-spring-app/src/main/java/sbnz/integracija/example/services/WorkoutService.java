package sbnz.integracija.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sbnz.integracija.example.models.Workout;
import sbnz.integracija.example.repository.WorkoutRepository;

@Service
public class WorkoutService {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	public List<Workout> findAll(){
		return workoutRepository.findAll();
    }

    public Optional<Workout> findById(Long id){
        return workoutRepository.findById(id);
    }
    
    public Workout save(Workout workout) throws Exception{
        return workoutRepository.save(workout);

    }
    
    public void delete(Workout wo) {
    	workoutRepository.delete(wo);
    }

}