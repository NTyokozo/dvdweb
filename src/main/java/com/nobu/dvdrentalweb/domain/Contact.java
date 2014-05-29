/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author nobu
 */
@Embeddable
public class Contact implements Serializable
{
    // private Long contactId;
     private String phoneNumber;
     private String emailaddress;

     private Contact()
    {
    }
    
    private Contact(Builder builder)
    {
        //contactId = builder.contactId;
        phoneNumber = builder.phoneNumber;
        emailaddress = builder.emailaddress;
       
    }
    public static class Builder
    {
      // private Long contactId;
       private String phoneNumber;
       private String emailaddress;
       
        public Builder()
        {
        }
//        public Builder contactId(Long value)
//        {
//            contactId = value;
//            return this;
//        }
        
        public Builder phoneNumber(String value)
        {
            phoneNumber = value;
            return this;
        }
        public Builder emailaddress(String value)
        {
            emailaddress = value;
            return this;
        }
        public Builder contact(Contact value)
        {
            //contactId = value.getContactId();
            phoneNumber = value.getPhoneNumber();
            emailaddress = value.getEmailaddress();
            return this;
        }
        public Contact build()
        {
            return new Contact(this);
        }
    }
//    public Long getContactId() {
//        return contactId;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

 
    
}
