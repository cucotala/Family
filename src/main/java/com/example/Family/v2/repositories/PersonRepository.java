package com.example.Family.v2.repositories;

import com.example.Family.v2.entitties.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {



}
