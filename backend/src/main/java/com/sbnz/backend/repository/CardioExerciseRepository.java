package com.sbnz.backend.repository;

import com.sbnz.backend.models.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardioExerciseRepository extends JpaRepository<Exercise, Long>{

    Exercise findeExById(Long id);

}
