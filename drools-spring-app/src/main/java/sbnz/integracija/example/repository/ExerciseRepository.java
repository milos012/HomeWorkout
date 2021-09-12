package sbnz.integracija.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

    Exercise findByName(String name);

}
