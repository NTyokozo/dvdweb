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
public class Suppliers implements Serializable 
{
    
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO) 
     private Long  supId;
    private String suptype;

     private Suppliers()
    {
    }
    
    private Suppliers(Builder builder)
    {
        supId = builder.supId;
        suptype = builder.suptype;
        
       
    }
    public static class Builder
    {
         private Long  supId;
         private String suptype;
        
        
        public Builder()
        {
        }
        public Builder subId(Long value)
        {
            supId = value;
            return this;
        }
        
        public Builder type(String value)
        {
            suptype = value;
            return this;
        }    
        public Builder sup(Suppliers value)
        {
            supId = value.getSupId();
            suptype = value.getSuptype();
           
            return this;
        }
        public Suppliers build()
        {
            return new Suppliers(this);
        }
    }

    public Long getSupId() {
        return supId;
    }

    public String getSuptype() {
        return suptype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.supId);
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
        final Suppliers other = (Suppliers) obj;
        return Objects.equals(this.supId, other.supId);
    }
    
}
