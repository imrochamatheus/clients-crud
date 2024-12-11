package com.imrochamatheus.clients_crud.repository;

import com.imrochamatheus.clients_crud.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
