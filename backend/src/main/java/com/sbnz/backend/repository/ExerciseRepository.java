package com.sbnz.backend.repository;

import com.sbnz.backend.models.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

    Exercise findByName(String name);

}
