package com.sbnz.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.backend.dto.WorkoutDTO;
import com.sbnz.backend.models.Workout;
import com.sbnz.backend.services.WorkoutService;


@RestController
@RequestMapping("/api/workout")
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<WorkoutDTO>> getAllWorkouts(){
        List<Workout> ex = workoutService.findAll();
        List<WorkoutDTO> exDTOs = new ArrayList<>();

        for (Workout wo : ex) {
        	WorkoutDTO novi = new WorkoutDTO(wo);
            exDTOs.add(novi);
        }

        return new ResponseEntity<>(exDTOs, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<WorkoutDTO> getWorkout(@PathVariable String id){
		Long l = Long.parseLong(id);
		Optional<Workout> ex = workoutService.findById(l);

        if (ex == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        WorkoutDTO woDTO = new WorkoutDTO(ex.get().getId(), ex.get().getDifficulty(), ex.get().getMuscleGroup());
        return new ResponseEntity<>(woDTO, HttpStatus.OK);

    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<WorkoutDTO> createWorkout(@RequestBody WorkoutDTO exDTO){
		Workout ex = new Workout();
		
		
        try {
        	ex.setId(exDTO.getId());
        	ex.setDifficulty(exDTO.getDifficulty());
            ex.setMuscleGroup(exDTO.getMuscleGroup());
            
            
            Workout test = workoutService.save(ex);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(exDTO, HttpStatus.CREATED);
    }

}
