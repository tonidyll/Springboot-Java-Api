/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.RepositoryPerson to edit this template
 */
package com.davia.api.Repository;

import com.davia.api.Modelo.Country;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author antonidavyll
 */
public interface CountryRepository extends JpaRepository<Country,Integer>{
    
}
