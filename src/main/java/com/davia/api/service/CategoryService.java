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
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    public List <Client>ListCategories(){
        return repository.findAll();
    }
    public void saveCategories (Client client){
        repository.save(client);
    }
    public Client getCategoryId (Integer id){
        return repository.findById(id).get();
    }
    public void deleteCategory (Integer id){
        repository.deleteById(id);
    }
    public void editCategory (Integer id){
        repository.existsById(id);
    }
}
