package com.example.Family.v2.repositories;

import com.example.Family.v2.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByName(String name);
}
