/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services;

import com.nobu.dvdrentalweb.domain.Movie;

/**
 *
 * @author nobu
 */
public interface MovieService extends Services<Movie , Long>
{
        public Movie getMovieName(String name);
        public int getNumberOfMoives();
        public int Rentedby(String CustName);
}
