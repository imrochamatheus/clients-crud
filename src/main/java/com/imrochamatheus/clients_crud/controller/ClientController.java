package com.imrochamatheus.clients_crud.controller;

import com.imrochamatheus.clients_crud.dto.ClientDTO;
import com.imrochamatheus.clients_crud.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/clients")
@RestController()
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<Page<ClientDTO>> findAll(
            @PageableDefault(
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable)
    {
        Page<ClientDTO> clientDTOPage = this.clientService.findAll(pageable);

        return ResponseEntity.ok(clientDTOPage);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById (@PathVariable Long id) {
        ClientDTO clientDTO = this.clientService.findById(id);

        return ResponseEntity.ok(clientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert (@RequestBody @Valid ClientDTO clientDTO) {
        clientDTO = this.clientService.insertClient(clientDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(clientDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update (@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) {
        clientDTO = this.clientService.updateClient(id, clientDTO);

        return ResponseEntity.ok(clientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        this.clientService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
