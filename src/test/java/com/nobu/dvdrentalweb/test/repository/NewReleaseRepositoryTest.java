/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Movie;
import com.nobu.dvdrentalweb.domain.NewRelease;
import com.nobu.dvdrentalweb.repository.NewReleaseRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author nobu
 */
public class NewReleaseRepositoryTest {
    
    public NewReleaseRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
      public static ApplicationContext ctx;
    private Long id;

    private NewReleaseRepository repo;
    
  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomer() {
        
        List <Movie> movie = new ArrayList<>();
        repo = ctx.getBean(NewReleaseRepository.class);
        NewRelease p = new NewRelease.Builder()
                .newavail(true)
                .yearofrelease(2013)
                .movie(movie)
                .build();
        repo.save(p);
        id = p.getNewid();
        Assert.assertNotNull(p);

    }

    @Test(dependsOnMethods = "createCustomer", enabled = true)
    public void readCustomer() {
        repo = ctx.getBean(NewReleaseRepository.class);
        NewRelease newRelease = repo.findOne(id);
        Assert.assertNotEquals(newRelease.getYearofrelease(), 2012);

    }

    @Test(dependsOnMethods = "readCustomer", enabled = true)
    private void updateCustomer() {
        repo = ctx.getBean(NewReleaseRepository.class);
        NewRelease newRelease = repo.findOne(id);
        NewRelease updatedPerson = new NewRelease.Builder()
                .newRelease(newRelease)
                .newavail(false)
                .build();

        repo.save(updatedPerson);

        NewRelease newRel= repo.findOne(id);
        Assert.assertEquals(newRel.getYearofrelease(), 2013);

    }

    @Test(dependsOnMethods = "updateCustomer", enabled = true)
    private void deleteCustomer() {
        repo = ctx.getBean(NewReleaseRepository.class);
        NewRelease newRelease = repo.findOne(id);
        repo.delete(newRelease);

         NewRelease deletedNewRelease = repo.findOne(id);

        Assert.assertNull(deletedNewRelease);

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
