/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services.Imp;

import com.nobu.dvdrentalweb.domain.Account;
import com.nobu.dvdrentalweb.domain.Payment;
import com.nobu.dvdrentalweb.domain.Person;
import com.nobu.dvdrentalweb.repository.AccountRepository;
import com.nobu.dvdrentalweb.repository.PersonsRepository;
import com.nobu.dvdrentalweb.services.PaymentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nobu
 */
public class PaymentServiceImp implements PaymentService{

    private final double TAX_AMOUNT = 0.14;
    
    @Autowired
    private  AccountRepository accrepo;
       
    @Override
    public List<Account> pay(double amount) 
    {
        List<Account> pay = new ArrayList<>();
        List <Account> allpayments = accrepo.findAll();
        
        for(Account pays : allpayments )
        {
            amount = pays.getAccount() * TAX_AMOUNT;
           pay.add(pays);
        }
        return pay;
    }

    @Override
    public List<Account> all() {
        return accrepo.findAll();
    }

    @Override
    public List<Account> account() {
        return accrepo.findAll();
    }
    
}
