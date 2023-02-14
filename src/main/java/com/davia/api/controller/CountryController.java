/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.davia.api.controller;

import com.davia.api.service.CountryService;
import com.davia.api.Modelo.Country;
import java.util.List;
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
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/Country")
    public List<Country> ListCountries() {
        return countryService.ListCountries();
    }

    @GetMapping("/Country/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Integer id) {
        try {
            Country country = countryService.getCountryById(id);
            return ResponseEntity.ok(country);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/Country")
    public void newCountry(@RequestBody Country country) {
        countryService.saveCountries(country);
    }

    @PutMapping("/Country/{id}")
    public ResponseEntity<?> editCountry(@RequestBody Country country, @PathVariable Integer id) {
        try {
            Country countryExists = countryService.getCountryById(id);
            countryExists.setCountry(country.getCountry());
            countryService.saveCountries(countryExists);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Country/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryService.deleteCountry(id);
    }
}
