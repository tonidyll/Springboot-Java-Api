/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.RepositoryPerson to edit this template
 */
package com.davia.api.Repository;

import com.davia.api.Modelo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author antonidavyll
 */
public interface CategoryRepository extends JpaRepository<Category,Integer>{
    
}
