package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
