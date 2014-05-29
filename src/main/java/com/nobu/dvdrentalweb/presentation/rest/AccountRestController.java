/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.presentation.rest;

import com.nobu.dvdrentalweb.domain.Account;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nobu
 */
@Controller
@RequestMapping(value = "api/account") 

public class AccountRestController {
    
    /**
     *
    
     * @return
     */
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Account account)
    {
        System.out.println("");
        return "";
    }
    
     @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Account account) {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "account/{id}")
    @ResponseBody
    public Account getAccount(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "account")
    @ResponseBody
    public List<Account> Accounts() {
        System.out.println("The Account");
        return null;
    }

    @RequestMapping(value = "account/{name}")
    @ResponseBody
    public Account getAccountName(@PathVariable String id) {
        System.out.println("The Account name");
        return null;
    }

}

    

