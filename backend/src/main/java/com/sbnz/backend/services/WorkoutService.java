package com.sbnz.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.backend.models.Workout;
import com.sbnz.backend.repository.WorkoutRepository;

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
