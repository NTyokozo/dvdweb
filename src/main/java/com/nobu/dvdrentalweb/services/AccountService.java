/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services;

import com.nobu.dvdrentalweb.domain.Account;

/**
 *
 * @author nobu
 */
public interface AccountService extends Services<Account, Long>
{
    public Account accountHolders(String members);
   
    
}
