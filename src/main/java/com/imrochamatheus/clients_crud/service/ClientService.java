package com.imrochamatheus.clients_crud.service;

import com.imrochamatheus.clients_crud.dto.ClientDTO;
import com.imrochamatheus.clients_crud.exception.ResourceNotFoundException;
import com.imrochamatheus.clients_crud.model.Client;
import com.imrochamatheus.clients_crud.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    private ClientDTO toDTO (Client client) {
        return this.modelMapper.map(client, ClientDTO.class);
    }

    private Client fromDTO (ClientDTO clientDTO) {
        return this.modelMapper.map(clientDTO, Client.class);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll (Pageable pageable) {
        return this.clientRepository.findAll(pageable)
                .map(this::toDTO);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = this.clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " does not exists"));

        return this.toDTO(client);
    }

    @Transactional()
    public ClientDTO insertClient (ClientDTO clientDTO) {
        Client client = this.fromDTO(clientDTO);
        client = this.clientRepository.save(client);

        return this.toDTO(client);
    }

    @Transactional()
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = this.clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " does not exists"));

        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setChild(clientDTO.getChild());
        client.setBirthDate(clientDTO.getBirthDate());

        client = this.clientRepository.save(client);

        return this.toDTO(client);
    }

    @Transactional()
    public void deleteById(Long id) {
        this.findById(id);
        this.clientRepository.deleteById(id);
    }
}
