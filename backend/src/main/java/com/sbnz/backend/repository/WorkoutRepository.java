package com.sbnz.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.backend.models.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{
	

}
