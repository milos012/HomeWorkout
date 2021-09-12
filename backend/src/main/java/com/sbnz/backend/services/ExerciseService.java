package com.sbnz.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.backend.models.Exercise;
import com.sbnz.backend.repository.ExerciseRepository;

@Service
public class ExerciseService {
	
	@Autowired
	ExerciseRepository exerciseRepository;
	
	public List<Exercise> findAll(){
		return exerciseRepository.findAll();
    }

    public Optional<Exercise> findById(Long id){
        return exerciseRepository.findById(id);
    }

    public Exercise findByName(String name){
        return exerciseRepository.findByName(name);
    }

    public Exercise save(Exercise exercise) throws Exception{
        return exerciseRepository.save(exercise);

    }
    
    public void delete(Exercise e) {
        exerciseRepository.delete(e);
    }

}
