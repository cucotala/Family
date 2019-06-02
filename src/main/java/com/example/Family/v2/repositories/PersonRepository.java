package com.example.Family.v2.repositories;

import com.example.Family.v2.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

Optional<Person> findByNameIgnoreCase(String name);

}
