/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.presentation.rest;

import com.nobu.dvdrentalweb.domain.Movie;
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
@RequestMapping(value = "api/movie")

public class MovieRestController {
    
    @RequestMapping(value = "create")
    @ResponseBody
   public String create(@RequestBody  Movie movie)
   {
       System.out.println(" Create the Called ");
        return "";
   }
    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Movie movie) {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "movie/{id}")
    @ResponseBody
    public Movie getMovie(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "movies")
    @ResponseBody
    public List<Movie> Movies() {
        System.out.println("The Movies");
        return null;
    }

    @RequestMapping(value = "movie/{name}")
    @ResponseBody
    public Movie getMovieName(@PathVariable String id) {
        System.out.println("The Movie name");
        return null;
    }

}
