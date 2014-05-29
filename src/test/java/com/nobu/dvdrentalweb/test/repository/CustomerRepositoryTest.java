/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Customer;
import com.nobu.dvdrentalweb.repository.CustomerRepository;
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
public class CustomerRepositoryTest {
    
    public CustomerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
      public static ApplicationContext ctx;
    private Long id;

    private CustomerRepository repo;
   // private Person person;
  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomer() {
        
        
        repo = ctx.getBean(CustomerRepository.class);
        Customer p = new Customer.Builder()
                .custType("Adult")
                //.person(person)
                .build();
        repo.save(p);
        id = p.getCustomerId();
        Assert.assertNotNull(p);

    }

    @Test(dependsOnMethods = "createCustomer", enabled = true)
    public void readCustomer() {
        repo = ctx.getBean(CustomerRepository.class);
        Customer customer = repo.findOne(id);
        Assert.assertEquals(customer.getCustType(), "Adult");

    }

    @Test(dependsOnMethods = "readCustomer", enabled = true)
    private void updateCustomer() {
        repo = ctx.getBean(CustomerRepository.class);
        Customer customer = repo.findOne(id);
        Customer updatedCustomer = new Customer.Builder()
                .customer(customer)
                .custType("Teen")
                .build();

        repo.save(updatedCustomer);

        Customer newCustomer= repo.findOne(id);
        Assert.assertEquals(newCustomer.getCustType(), "Teen");

    }

    @Test(dependsOnMethods = "updateCustomer", enabled = true)
    private void deleteCustomer() {
        repo = ctx.getBean(CustomerRepository.class);
        Customer customer = repo.findOne(id);
        repo.delete(customer);

         Customer deletedCustomer = repo.findOne(id);

        Assert.assertNull(deletedCustomer);

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
