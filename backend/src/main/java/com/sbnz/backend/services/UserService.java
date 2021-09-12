package com.sbnz.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.backend.models.User;
import com.sbnz.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }


    public User save(User user) throws Exception{
        return userRepository.save(user);

    }
    
    public void delete(User u) {
        userRepository.delete(u);
    }

}
