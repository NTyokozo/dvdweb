/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.services;

import com.nobu.dvdrentalweb.domain.Account;
import com.nobu.dvdrentalweb.domain.Payment;
import com.nobu.dvdrentalweb.repository.AccountRepository;
import com.nobu.dvdrentalweb.services.PaymentService;
import com.nobu.dvdrentalweb.test.ConnectionConfigTest;
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
public class PaymentServiceTest {
    
    private static ApplicationContext ctx;
    private AccountRepository accrepo;
    //private PaymentRepository payrepo;
    private PaymentService payser;
    
    public PaymentServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getAmount() 
     {
        accrepo = ctx.getBean(AccountRepository.class);
        // payrepo = ctx.getBean(PaymentRepository.class);
          //  payser = ctx.getBean(PaymentService.class);
            
            
         Payment pay1 = new Payment.Builder().amount(120.00)
                 .paymentMethod("Monthly")
                 .paymentType("Cheque Account")
                 .build();
          Payment pay2 = new Payment.Builder().amount(100.00)
                 .paymentMethod("Weekly")
                 .paymentType("Cheque Account")
                 .build();
          Payment pay3 = new Payment.Builder().amount(85.00)
                 .paymentMethod("When Booking")
                 .paymentType("Cash")
                 .build();
         
         Account acc = new Account.Builder().accountName("Saving")
                 .pay(pay1)
                 .build();
                 
        
  Account acc1 = new Account.Builder().accountName("Cheque")
                 .pay(pay2)
                 .build();
  
  Account acc2 = new Account.Builder().accountName("Current")
                 .pay(pay3)
                 .build();
         accrepo.save(acc);
          accrepo.save(acc1);
           accrepo.save(acc2);
           
         //  List <Account> pay = payser.pay(120.00);
           
        //   Assert.assertEquals(pay.size(),3);
     }
    @BeforeClass
    public static void setUpClass() throws Exception 
    {
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
