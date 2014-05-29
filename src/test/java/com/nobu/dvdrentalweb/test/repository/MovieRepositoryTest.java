/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.BlueRay;
import com.nobu.dvdrentalweb.domain.Dvd;
import com.nobu.dvdrentalweb.domain.Genre;
import com.nobu.dvdrentalweb.domain.Movie;
import com.nobu.dvdrentalweb.domain.Payment;
import com.nobu.dvdrentalweb.domain.RentDate;
import com.nobu.dvdrentalweb.repository.MovieRepository;
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
public class MovieRepositoryTest {
    
    public MovieRepositoryTest() {
    }

     public static ApplicationContext ctx;
     private Long id;

    private MovieRepository repo;
    
    private  Genre genre;
    private  RentDate rent;
    private  Payment pay;

    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createMovie() {
      List  <Dvd> dvd = new ArrayList<>();
       List <BlueRay> blue = new ArrayList<>();
        
       
       
       genre = new Genre.Builder().genType("Horror").build();
        rent = new RentDate.Builder().rentdate("2014-10-20")
                .returndate("2014-10-25").build();
        pay = new Payment.Builder()
                .amount(120.00).paymentMethod("Monthly").paymentType("Cheque").build();
        
        
        
        repo = ctx.getBean(MovieRepository.class);
        Movie p = new Movie.Builder()
                .producer("Queen Latifah")
                .movielength(160)
                .numberOfCopies(100)
               .moviename("Set it off")
                .genre(genre)
                .rent(rent)
                .blue(blue)
                .dvd(dvd)
                //.agerestriction(18)
                .build();
        repo.save(p);
        id = p.getMovieId();
        Assert.assertNotNull(p);

    }

    @Test(dependsOnMethods = "createMovie", enabled = true)
    public void readMovie() {
        repo = ctx.getBean(MovieRepository.class);
        Movie movie = repo.findOne(id);
        Assert.assertEquals(movie.getProducer(), "Queen Latifah");

    }

    @Test(dependsOnMethods = "readMovie", enabled = true)
    private void updateMovie() {
        repo = ctx.getBean(MovieRepository.class);
        Movie movie = repo.findOne(id);
        Movie updatedMovie = new Movie.Builder()
                .account(movie)
                .numberOfCopies(95)
                .build();

        repo.save(updatedMovie);

        Movie newMovie = repo.findOne(id);
        Assert.assertEquals(newMovie.getNumberOfCopies(), 95);

    }

    @Test(dependsOnMethods = "updateMovie", enabled = true)
    private void deleteMovie() {
        repo = ctx.getBean(MovieRepository.class);
        Movie movie = repo.findOne(id);
        repo.delete(movie);

        Movie deletedMovie = repo.findOne(id);

        Assert.assertNull(deletedMovie);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        
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
