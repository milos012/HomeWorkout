package sbnz.integracija.example.controllers;

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

import sbnz.integracija.example.dto.UserDTO;
import sbnz.integracija.example.models.User;
import sbnz.integracija.example.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<User> u = userService.findAll();
        List<UserDTO> uDTOs = new ArrayList<>();

        for (User user : u) {
        	UserDTO novi = new UserDTO(user);
            uDTOs.add(novi);
        }

        return new ResponseEntity<>(uDTOs, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable String id){
		Long l = Long.parseLong(id);
		Optional<User> ex = userService.findById(l);

        if (ex == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        UserDTO uDTO = new UserDTO(ex.get().getId(), ex.get().getWeight(), ex.get().getHeight(), ex.get().getPl(), ex.get().getEquipment());
        return new ResponseEntity<>(uDTO, HttpStatus.OK);

    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO exDTO){
		User ex = new User();
        try {
        	ex.setId(exDTO.getId());
        	ex.setWeight(exDTO.getWeight());
        	ex.setHeight(exDTO.getHeight());
        	ex.setPl(exDTO.getPl());
        	ex.setEquipment(exDTO.getEquipment());
            
            User test = userService.save(ex);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(exDTO, HttpStatus.CREATED);
    }

}
