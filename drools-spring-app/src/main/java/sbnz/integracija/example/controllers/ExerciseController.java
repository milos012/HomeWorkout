package sbnz.integracija.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import sbnz.integracija.example.dto.ExerciseDTO;
import sbnz.integracija.example.models.Exercise;
import sbnz.integracija.example.services.ExerciseService;


@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ExerciseDTO>> getAllExercises(){
        List<Exercise> ex = exerciseService.findAll();
        List<ExerciseDTO> exDTOs = new ArrayList<>();

        for (Exercise e : ex) {
            ExerciseDTO novi = new ExerciseDTO(e);
            exDTOs.add(novi);
        }

        return new ResponseEntity<>(exDTOs, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<ExerciseDTO> getExercise(@PathVariable String name){
		Exercise ex = exerciseService.findByName(name);

        if (ex == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        ExerciseDTO exDTO = new ExerciseDTO(ex.getId(), ex.getName(), ex.getDescription(), ex.getWorkoutType(), ex.getRequiredEquipment(), ex.getDifficulty());

        return new ResponseEntity<>(exDTO, HttpStatus.OK);

    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody ExerciseDTO exDTO){
		Exercise ex = new Exercise();
        try {
        	ex.setId(exDTO.getId());
        	ex.setName(exDTO.getName());
            ex.setDescription(exDTO.getDescription());
            ex.setWorkoutType(exDTO.getWorkoutType());
            ex.setRequiredEquipment(exDTO.getRequiredEquipment());
            ex.setDifficulty(exDTO.getDifficulty());
            
            Exercise test = exerciseService.save(ex);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(exDTO, HttpStatus.CREATED);
    }

}
