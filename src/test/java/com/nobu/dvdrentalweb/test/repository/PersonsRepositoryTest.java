package com.nobu.dvdrentalweb.test.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nobu.dvdrentalweb.app.conf.ConnectionConfig;
import com.nobu.dvdrentalweb.domain.Account;
import com.nobu.dvdrentalweb.domain.Address;
import com.nobu.dvdrentalweb.domain.Contact;
import com.nobu.dvdrentalweb.domain.Person;
import com.nobu.dvdrentalweb.domain.Subscription;
import com.nobu.dvdrentalweb.repository.PersonsRepository;
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

/*c*
 *
 * @author nobu
 */
public class PersonsRepositoryTest {

    public static ApplicationContext ctx;
    private Long id;

    private PersonsRepository repo;
    
   // private static Contact contact;
    //private static Address address;

    public PersonsRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createPerson() {
        List <Account> accounts = new ArrayList<>();
        List<Subscription> sub = new ArrayList<>();
        
        Contact contact = new Contact.Builder().emailaddress("nobub@gmial.com").phoneNumber("021345685").build();
        Address address = new Address.Builder().location("Daveyton").streetName("Phaswane Street").houseNumber(45).build();
        
        repo = ctx.getBean(PersonsRepository.class);
        Person p = new Person.Builder()
                .firstname("Nobu")
                .lastname("Tyokz")
                .age(25)
                .account(accounts)
                .sub(sub)
                .contact(contact)
                .address(address)
                .build();
        repo.save(p);
        id = p.getId();
        Assert.assertNotNull(p);

    }

    @Test(dependsOnMethods = "createPerson", enabled = true)
    public void readPerson() {
        repo = ctx.getBean(PersonsRepository.class);
        Person person = repo.findOne(id);
        Assert.assertEquals(person.getFirstname(), "Nobu");

    }

    @Test(dependsOnMethods = "readPerson", enabled = true)
    private void updatePerson() {
        repo = ctx.getBean(PersonsRepository.class);
        Person person = repo.findOne(id);
        Person updatedPerson = new Person.Builder()
                .person(person)
                .firstname("nobubele")
                .build();

        repo.save(updatedPerson);

        Person newPerson = repo.findOne(id);
        Assert.assertEquals(newPerson.getFirstname(), "nobubele");

    }

    @Test(dependsOnMethods = "updatePerson", enabled = true)
    private void deletePerson() {
        repo = ctx.getBean(PersonsRepository.class);
        Person person = repo.findOne(id);
        repo.delete(person);

        Person deletedPerson = repo.findOne(id);

        Assert.assertNull(deletedPerson);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        //contact = new Contact.Builder().phoneNumber("021345685").build();
        //address = new Address.Builder().houseNumber(45).build();
        
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
