/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.services;

import com.nobu.dvdrentalweb.domain.BlueRay;
import com.nobu.dvdrentalweb.domain.Dvd;
import com.nobu.dvdrentalweb.domain.Genre;
import com.nobu.dvdrentalweb.domain.Movie;
import com.nobu.dvdrentalweb.domain.RentDate;
import com.nobu.dvdrentalweb.repository.DvdRepository;
import com.nobu.dvdrentalweb.repository.MovieRepository;
import com.nobu.dvdrentalweb.services.AvailableMoviesService;
import com.nobu.dvdrentalweb.test.ConnectionConfigTest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author nobu
 */
public class AvailableMoviesServiceTest {
    
     public static ApplicationContext ctx;

    private AvailableMoviesService service;
    private MovieRepository movieRepository;
    private DvdRepository dvdRepository;
    private RentDate rent;
    private  Genre genre;
    
  
    private Long id;
    
    public AvailableMoviesServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
      @Test
    public void testDvd() {
        dvdRepository = ctx.getBean(DvdRepository.class);
        Dvd dvd1 = new Dvd.Builder().dvdLength("120").build();
         Dvd dvd2 = new Dvd.Builder().dvdLength("100").build();

        dvdRepository.save(dvd1);
        dvdRepository.save(dvd2);

    }

       @Test(dependsOnMethods = "testDvd",enabled = true)
    private void createMovie() {
        dvdRepository = ctx.getBean(DvdRepository.class);
        movieRepository = ctx.getBean(MovieRepository.class);

        List<Dvd> dvd = new ArrayList<>();

        Dvd d1 = new Dvd.Builder().dvdLength("120").dvdSpeed("120 watts").build();
        Dvd d2 = new Dvd.Builder().dvdLength("60").dvdSpeed("60 watts").build();
        Dvd d3 = new Dvd.Builder().dvdLength("300").dvdSpeed("150 watts").build();
        dvd.add(d1);
        dvd.add(d2);
        dvd.add(d3);

        List<Dvd> dvds = dvdRepository.findAll();

        Movie movie = new Movie.Builder()
                .dvd(dvds)
                .movielength(120)
                .moviename("Evil Dead")
                .numberOfCopies(20)
                .producer("Mr Smith")
                .status(true)
                .genre(genre)
                //.rent(null)
                .rent(rent)
                .build();

        movieRepository.save(movie);
        id = movie.getMovieId();

        Assert.assertNotNull(movie);
    }

      @Test(dependsOnMethods = "createMovie" ,enabled = true)
    private void readDvd() {
        movieRepository = ctx.getBean(MovieRepository.class);
         Movie movie = movieRepository.findOne(id);
      
        List<Dvd> dvd = movie.getDvd();

        for (Dvd dvds : dvd) {
            System.out.println("Dvd Length is :"+ dvds.getDvdLength() + " Dvd Speed is :" + dvds.getDvdSpeed());

        }
    }

     @Test(dependsOnMethods = "readDvd" ,enabled = true)
    private void readBlueRay() {
        movieRepository = ctx.getBean(MovieRepository.class);
         Movie movie = movieRepository.findOne(id);
      
        List<BlueRay> blue = movie.getBlue();

        for (BlueRay blues : blue) {
            System.out.println("BlueRay speed  is :"+ blues.getBlueSpeed() + " Dvd Visual is :" + blues.getVisual());

        }
    }
      @Test(enabled = true)
    public void ListAll() {
        service = ctx.getBean(AvailableMoviesService.class);
        List<Movie> movie = service.getMovies();

        Assert.assertNotEquals(movie.size(), 2, " Expert no Movies");

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
