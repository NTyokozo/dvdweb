/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.presentation.rest;

import com.nobu.dvdrentalweb.domain.Account;
import org.springframework.stereotype.Controller;
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
    
}
