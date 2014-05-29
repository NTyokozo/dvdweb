/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services.Imp;

import com.nobu.dvdrentalweb.domain.Customer;
import com.nobu.dvdrentalweb.domain.Movie;
import com.nobu.dvdrentalweb.repository.CustomerRepository;
import com.nobu.dvdrentalweb.repository.MovieRepository;
import com.nobu.dvdrentalweb.services.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nobu
 */
public class MovieServiceImp implements MovieService {

     @Autowired
     private MovieRepository movierepo;
     @Autowired
     private CustomerRepository custrepo; 
   
     @Override
    public Movie getMovieName(String name) {
        
        List<Movie> movie = findAll();
        Movie foundMovie = null;
        for (Movie movies : movie) {
            if (movies.getMoviename().equalsIgnoreCase(name)) {
                foundMovie = movies;
            }
        }
        return foundMovie;
    }

    @Override
    public int getNumberOfMoives() {
        List<Movie> movies = findAll();
        return movies.size();
    }

    @Override
    public int Rentedby(String rentedby) {
        List<Customer> cust = custrepo.findAll();
        Movie movie = getMovieName(rentedby);
        List<Customer> custs = new ArrayList<>();
        for(Customer customer: custs){
            if(customer.getCustType().contains((CharSequence) movie)){
                custs.add(customer);
            }
        }
        return custs.size();   
    }

    @Override
    public Movie find(Long id) {
        return movierepo.findOne(id);
    }

    @Override
    public Movie persist(Movie entity) {
        return movierepo.save(entity);
    }

    @Override
    public Movie merge(Movie entity) {
        if (entity.getMovieId() != null ) {
          return movierepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Movie entity) {
          movierepo.delete(entity);
    }

    @Override
    public List<Movie> findAll() {
        return movierepo.findAll();
    }
    
}
