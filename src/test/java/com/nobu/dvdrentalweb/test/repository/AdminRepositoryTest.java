/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.repository;

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Admin;
import com.nobu.dvdrentalweb.repository.AdminRepository;
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
public class AdminRepositoryTest {
    
    public AdminRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   public static ApplicationContext ctx;
    private Long id;

    private AdminRepository repo;
    
  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomer() {
        
        
        repo = ctx.getBean(AdminRepository.class);
        Admin p = new Admin.Builder()
                .stations("All Stations")
                .password("2356")
                .build();
        repo.save(p);
        id = p.getAdminId();
        Assert.assertNotNull(p);

    }

    @Test(dependsOnMethods = "createCustomer", enabled = true)
    public void readCustomer() {
        repo = ctx.getBean(AdminRepository.class);
        Admin admin = repo.findOne(id);
        Assert.assertNotEquals(admin.getPassword() , "2345");

    }

    @Test(dependsOnMethods = "readCustomer", enabled = true)
    private void updateCustomer() {
        repo = ctx.getBean(AdminRepository.class);
        Admin admin = repo.findOne(id);
        Admin updatedPerson = new Admin.Builder()
                .admin(admin)
                .stations("Station 1")
                .password("1234")
                .build();

        repo.save(updatedPerson);

        Admin newAdmin= repo.findOne(id);
        Assert.assertEquals(newAdmin.getPassword(),"1234");

    }

    @Test(dependsOnMethods = "updateCustomer", enabled = true)
    private void deleteCustomer() {
        repo = ctx.getBean(AdminRepository.class);
        Admin admin = repo.findOne(id);
        repo.delete(admin);

         Admin deletedAdmin = repo.findOne(id);

        Assert.assertNull(deletedAdmin);

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
