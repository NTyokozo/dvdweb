/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author nobu
 */
@Embeddable
public class RentDate implements Serializable
{
    private String returndate;
    private String rentdate;

     private RentDate()
    {
    }
    
    private RentDate(Builder builder)
    {
        returndate = builder.returndate;
        rentdate = builder.rentdate;
        
       
    }
    public static class Builder
    {
        private String returndate;
        private String rentdate;
        
        
        public Builder()
        {
        }
        public Builder returndate(String value)
        {
            returndate = value;
            return this;
        }
        
        public Builder rentdate(String value)
        {
            rentdate = value;
            return this;
        }    
        public Builder admin(RentDate value)
        {
            returndate = value.getReturndate();
            rentdate = value.getRentdate();
           
            return this;
        }
        public RentDate build()
        {
            return new RentDate(this);
        }
    }

    public String getReturndate() {
        return returndate;
    }

    public String getRentdate() {
        return rentdate;
    }
    
}
