/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.davia.api.controller;

import com.davia.api.service.CategoryService;
import com.davia.api.Modelo.Category;
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
public class CategoryController {

    private final CategoryService clientService;

    @GetMapping("/Category")
    public java.util.List <Category>ListClients(){
        return clientService.ListCategories();
    }

    @GetMapping("/Category/{id}")
    public ResponseEntity<Category> getClient(@PathVariable Integer id) {
        try {
            Category client = clientService.getCategoryById(id);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/Category")
    public void newClient(@RequestBody Category category) {
        clientService.saveCategories(category);
    }

    @PutMapping("/Category/{id}")
    public ResponseEntity<?> editClient(@RequestBody Category category, @PathVariable Integer id) {
        try {
            Category clientExist = clientService.getCategoryById(id);
            clientExist.setUsername(category.getUsername());
            clientExist.setLast_name(category.getLast_name());
            clientExist.setCountry(category.getCountry());
            clientService.saveCategories(CategoryExist);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/Category/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
