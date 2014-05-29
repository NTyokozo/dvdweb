/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services.Imp;

import com.nobu.dvdrentalweb.domain.Person;
import com.nobu.dvdrentalweb.repository.PersonsRepository;
import com.nobu.dvdrentalweb.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nobu
 */
@Service
public class PersonServiceImp implements PersonService{

     @Autowired
    private PersonsRepository personRepo;

    @Override
    public Person find(Long id) {
        return personRepo.findOne(id);
    }

    @Override
    public Person persist(Person entity) {
        return personRepo.save(entity);
    }

    @Override
    public Person merge(Person entity) {
        if (entity.getId()!=null) {
            return personRepo.save(entity);
        }
        return null;
        }

    @Override
    public void remove(Person entity) {
    
        personRepo.delete(entity);
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }
    
}
