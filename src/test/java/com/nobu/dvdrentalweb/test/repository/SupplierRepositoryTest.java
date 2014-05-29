/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Suppliers;
import com.nobu.dvdrentalweb.repository.SupplierRepository;
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
public class SupplierRepositoryTest {
    
    public SupplierRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
      public static ApplicationContext ctx;
    private Long id;

    private SupplierRepository repo;
    
  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createSupplier() {
        
        
        repo = ctx.getBean(SupplierRepository.class);
        Suppliers p = new Suppliers.Builder()
                .type("Dvd Supplier")
                .build();
        repo.save(p);
        id = p.getSupId();
        Assert.assertNotNull(p);

    }

    @Test(dependsOnMethods = "createSupplier", enabled = true)
    public void readSupplier() {
        repo = ctx.getBean(SupplierRepository.class);
        Suppliers supplier = repo.findOne(id);
        Assert.assertEquals(supplier.getSuptype(), "Dvd Supplier");

    }

    @Test(dependsOnMethods = "readSupplier", enabled = true)
    private void updateSupplier() {
        repo = ctx.getBean(SupplierRepository.class);
        Suppliers supplier = repo.findOne(id);
        Suppliers updatedPerson = new Suppliers.Builder()
                .sup(supplier)
                .type("Blue Ray")
                .build();

        repo.save(updatedPerson);

        Suppliers newsupplier= repo.findOne(id);
        Assert.assertEquals(newsupplier.getSuptype(), "Blue Ray");

    }

    @Test(dependsOnMethods = "updateSupplier", enabled = true)
    private void deleteCustomer() {
        repo = ctx.getBean(SupplierRepository.class);
        Suppliers supplier = repo.findOne(id);
        repo.delete(supplier);

         Suppliers deletedsupplier = repo.findOne(id);

        Assert.assertNull(deletedsupplier);

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
