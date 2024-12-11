package com.imrochamatheus.clients_crud.services;

import com.imrochamatheus.clients_crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
}
