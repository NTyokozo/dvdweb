/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nobu
 */
@Embeddable
public class Payment implements Serializable 
{
 
        private String paymentType;
        private double amount; 
        private String paymentMethod;

     private Payment()
    {
    }
    
    private Payment(Builder builder)
    {
     
        paymentType = builder.paymentType;
        amount = builder.amount;
         paymentMethod = builder.paymentMethod;
        
        
       
    }
     public static class Builder
    {
       
        private String paymentType;
        private double amount; 
        private String paymentMethod; 
    
        
        public Builder()
        {
        }
        
        public Builder paymentType(String value)
        {
            paymentType = value;
            return this;
        }
        public Builder amount(double value)
        {
            amount = value;
            return this;
        }
        public Builder paymentMethod(String value)
        {
            paymentMethod = value;
            return this;
        }
        public Builder payment(Payment value)
        {
          
            paymentType = value.getPaymentType();
            amount = value.getAmount();
            paymentMethod = value.getPaymentMethod();
            return this;
        }
        public Payment build()
        {
            return new Payment (this);
        }
    }
    

    public String getPaymentType() {
        return paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

   
    
}
