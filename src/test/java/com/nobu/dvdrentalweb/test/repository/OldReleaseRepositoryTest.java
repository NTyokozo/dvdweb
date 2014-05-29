/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Movie;
import com.nobu.dvdrentalweb.domain.OldRelease;
import com.nobu.dvdrentalweb.repository.OldReleaseRepository;
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
public class OldReleaseRepositoryTest {
    
    public OldReleaseRepositoryTest() {
    }

     // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
      public static ApplicationContext ctx;
    private Long id;

    private OldReleaseRepository repo;
    
  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomer() {
        
        List <Movie> movie = new ArrayList<>();
        repo = ctx.getBean(OldReleaseRepository.class);
        OldRelease p = new OldRelease.Builder()
                .oldavail(false)
                .yearofrelease(2014)
                .movie(movie)
                .build();
        repo.save(p);
        id = p.getOldid();
        Assert.assertNotNull(p);

    }

    @Test(dependsOnMethods = "createCustomer", enabled = true)
    public void readCustomer() {
        repo = ctx.getBean(OldReleaseRepository.class);
        OldRelease newRelease = repo.findOne(id);
        Assert.assertNotEquals(newRelease.getYearofrelease(), 2012);

    }

    @Test(dependsOnMethods = "readCustomer", enabled = true)
    private void updateCustomer() {
        repo = ctx.getBean(OldReleaseRepository.class);
        OldRelease oldRelease = repo.findOne(id);
        OldRelease updatedPerson = new OldRelease.Builder()
                .oldRelease(oldRelease)
                .oldavail(true)
                .build();

        repo.save(updatedPerson);

        OldRelease newRel= repo.findOne(id);
        Assert.assertEquals(newRel.getYearofrelease(), 2014);

    }

    @Test(dependsOnMethods = "updateCustomer", enabled = true)
    private void deleteCustomer() {
        repo = ctx.getBean(OldReleaseRepository.class);
        OldRelease oldRelease = repo.findOne(id);
        repo.delete(oldRelease);

         OldRelease deletedOldRelease = repo.findOne(id);

        Assert.assertNull(deletedOldRelease);

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
