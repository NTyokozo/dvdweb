/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.presentation.rest;

import com.nobu.dvdrentalweb.domain.Person;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nobu
 */
@Controller
@RequestMapping(value = "api/person")
public class PersonRestController {
    
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Person person) {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Person person) {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "Movie/{id}")
    @ResponseBody
    public Person getPerson(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "movies")
    @ResponseBody
    public List<Person> getPersons() {
        System.out.println("The MOVIES");
        return null;
    }

    @RequestMapping(value = "movie/{name}")
    @ResponseBody
    public Person getPersonyName(@PathVariable String id) {
        System.out.println("The Movie name");
        return null;
    }

}

