/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services;

import com.nobu.dvdrentalweb.domain.Movie;
import java.util.List;

/**
 *
 * @author nobu
 */
public interface AvailableMoviesService 
{
    public List<Movie> getMovies() ;
}
