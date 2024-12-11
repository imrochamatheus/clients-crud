package com.imrochamatheus.clients_crud.repositories;

import com.imrochamatheus.clients_crud.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
