package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.models.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{
	

}
