/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.ClientService to edit this template
 */
package com.davia.api.service;

import com.davia.api.Modelo.Country;
import com.davia.api.Repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author antonidavyll
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> ListCountries() {
        return repository.findAll();
    }

    public void saveCountries(Country country) {
        repository.save(country);
    }

    public Country getCountryById(Integer id) {
        return repository.findById(id).get();
    }

    public void deleteCountry(Integer id) {
        repository.deleteById(id);
    }

    public void editCountry(Integer id) {
        repository.existsById(id);
    }

}
