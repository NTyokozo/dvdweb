/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services.Imp;

import com.nobu.dvdrentalweb.domain.Movie;
import com.nobu.dvdrentalweb.repository.MovieRepository;
import com.nobu.dvdrentalweb.services.AvailableMoviesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nobu
 */
@Service
public class AvailableMovieServiceImp implements AvailableMoviesService{

    @Autowired
    private MovieRepository movieRepository;
    
    
    @Override
    public List<Movie> getMovies() {
      
        return movieRepository.findAll();
    }
    
}
