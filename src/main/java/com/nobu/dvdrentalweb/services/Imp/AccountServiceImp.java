/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services.Imp;

import com.nobu.dvdrentalweb.domain.Account;
import com.nobu.dvdrentalweb.repository.AccountRepository;
import com.nobu.dvdrentalweb.repository.CustomerRepository;
import com.nobu.dvdrentalweb.services.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nobu
 */
@Service
public class AccountServiceImp implements  AccountService 
{
     @Autowired
     private AccountRepository accrepo;
     @Autowired
     private CustomerRepository custepo;
     
    @Override
    public Account accountHolders(String names) {
        List<Account> account = findAll();
        Account findAccount = new Account.Builder().accountName("Savings").build();
        for (Account accounts : account) {
            if (accounts.getAccountName().equalsIgnoreCase(names)) {
                findAccount = accounts;
            }
        }
        return findAccount;  
    }

    @Override
    public Account find(Long id) {
       return accrepo.findOne(id);
   
    }

    @Override
    public Account persist(Account entity) {
            return accrepo.save(entity);
    }

    @Override
    public Account merge(Account entity) 
    {
            if (entity.getAccountId() != null) {
            return accrepo.save(entity);
        }
        return null;  
    }
    @Override
    public void remove(Account entity)
    {
            accrepo.delete(entity);  
    }
            
    @Override
    public List<Account> findAll() {
        return accrepo.findAll();
    }
    
}
