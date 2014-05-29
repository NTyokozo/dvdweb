/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services;

import com.nobu.dvdrentalweb.domain.Account;
import com.nobu.dvdrentalweb.domain.Payment;
import com.nobu.dvdrentalweb.domain.Subscription;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author nobu
 */
@Service 
public interface PaymentService {
    
    public List<Account> pay(double amount);
    public List<Account> all();
    public List <Account> account();
    
    
    
}
