/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.services;

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Dvd;
import com.nobu.dvdrentalweb.services.DvdCostService;
import com.nobu.dvdrentalweb.test.ConnectionConfigTest;
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
public class DvdCostServiceTest {
    
    public DvdCostServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     public static ApplicationContext ctx;
    public DvdCostService dvdservice;
    
    @Test
    public void DvdCostServiceTest() {
        Dvd dvd = new Dvd.Builder().dvdLength("120.00").dvdSpeed("66").dvdPrice(120.00).build();
        Dvd dvd1 = new Dvd.Builder().dvdLength("130.00").dvdSpeed("20").dvdPrice(99.00).build();
        Dvd dvd2 = new Dvd.Builder().dvdLength("140.00").dvdSpeed("80").dvdPrice(300.00).build();
        
        List<Dvd> dvdcost = new ArrayList<>();
        dvdcost.add(dvd);
        dvdcost.add(dvd1);
        dvdcost.add(dvd2);
        
       // Assert.assertEquals(dvdservice.highestCost(dvdcost), dvd2);
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
