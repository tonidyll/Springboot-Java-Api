/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.ClientService to edit this template
 */
package com.davia.api.service;

import com.davia.api.Modelo.Client;
import com.davia.api.Repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author antonidavyll
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> ListClients() {
        return repository.findAll();
    }

    public void saveClients(Client client) {
        repository.save(client);
    }

    public Client getClientById(Integer id) {
        return repository.findById(id).get();
    }

    public void deleteClient(Integer id) {
        repository.deleteById(id);
    }

    public void editClient(Integer id) {
        repository.existsById(id);
    }
}
