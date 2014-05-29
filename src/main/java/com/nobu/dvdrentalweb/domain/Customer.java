/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nobu
 */
@Entity
public class Customer implements Serializable 
{
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String custType;
    //@ManyToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name = "customer_id")
   // Person person;

     private Customer()
    {
    }
    
    private Customer(Builder builder)
    {
        customerId = builder.customerId;
        custType = builder.custType;
       // person = builder.person;
       
       
    }
    public static class Builder
    {
      private Long customerId;
     private String custType;
   //  private Person person;
       
        public Builder()
        {
        }
        public Builder customerId(Long value)
        {
            customerId = value;
            return this;
        }
        
        public Builder custType(String value)
        {
            custType = value;
            return this;
        }
        public Builder customer(Customer value)
        {
            customerId = value.getCustomerId();
            custType = value.getCustType();
           // person = value.getPerson();
            return this;
        }
//        public Builder person(Person value )
//        {
//            person = value;
//            return this;
//        }
        public Customer build()
        {
            return new Customer(this);
        }
    }
    public Long getCustomerId() {
        return customerId;
    }

    public String getCustType() {
        return custType;
    }

//    public Person getPerson() {
//        return person;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.customerId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return Objects.equals(this.customerId, other.customerId);
    }
    
   
}
