/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.davia.api.controller;

import com.davia.api.service.ClientService;
                        import com.davia.api.Modelo.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

/**
 *
 * @author antonidavyll
 */
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/Client")
    public java.util.List <Client>ListClients(){
        return clientService.ListClients();
    }

    @GetMapping("/Client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id) {
        try {
            Client client = clientService.getClientById(id);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/Client")
    public void newClient(@RequestBody Client client) {
        clientService.saveClients(client);
    }

    @PutMapping("/Client/{id}")
    public ResponseEntity<?> editClient(@RequestBody Client client, @PathVariable Integer id) {
        try {
            Client clientExist = clientService.getClientById(id);
            clientExist.setUsername(client.getUsername());
            clientExist.setLast_name(client.getLast_name());
            clientExist.setCountry(client.getCountry());
            clientService.saveClients(clientExist);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/Client/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
