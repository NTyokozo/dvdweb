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
public class Subscription implements  Serializable
{
    private static final long serialVersionUID = 1L;
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Id
    private Long  subId;
    private String type;

     private Subscription()
    {
    }
    
    private Subscription(Builder builder)
    {
        subId = builder.subId;
        type = builder.type;
        
       
    }
    public static class Builder
    {
        private Long  subId;
    private String type;
        
        
        public Builder()
        {
        }
        public Builder subId(Long value)
        {
            subId = value;
            return this;
        }
        
        public Builder type(String value)
        {
            type = value;
            return this;
        }    
        public Builder sub(Subscription value)
        {
            subId = value.getSubId();
            type = value.getType();
           
            return this;
        }
        public Subscription build()
        {
            return new Subscription(this);
        }
    }

    public Long getSubId() {
        return subId;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.subId);
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
        final Subscription other = (Subscription) obj;
        if (!Objects.equals(this.subId, other.subId)) {
            return false;
        }
        return true;
    }
    
}
