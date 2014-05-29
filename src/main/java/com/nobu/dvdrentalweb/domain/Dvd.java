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
public class Dvd implements Serializable 
{
   public static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dvdId;
    private String dvdLength;
    private String dvdSpeed; 
    private double dvdPrice;
    
      private Dvd()
    {
    }
    
    private Dvd(Builder builder)
    {
        dvdId = builder.dvdId;
        dvdLength = builder.dvdLength;
        dvdSpeed = builder.dvdSpeed;
        dvdPrice = builder.dvdPrice;
    }

     public static class Builder
    {
        private Long dvdId;
        private String dvdLength;
        private String dvdSpeed; 
        private double dvdPrice;
        
    
        
        public Builder()
        {
        }
        public Builder dvdId(Long value)
        {
            dvdId = value;
            return this;
        }
        
        public Builder dvdLength(String value)
        {
            dvdLength = value;
            return this;
        }
        public Builder dvdSpeed(String value)
        {
            dvdSpeed = value;
            return this;
        }
         public Builder dvdPrice(double value)
        {
            dvdPrice = value;
            return this;
        }
        public Builder dvd(Dvd value)
        {
            dvdId = value.getDvdId();
            dvdLength = value.getDvdLength();
            dvdSpeed = value.getDvdSpeed();
            dvdPrice = value.getDvdPrice();
            return this;
        }
        public Dvd build()
        {
            return new Dvd (this);
        }
    }
    public Long getDvdId() {
        return dvdId;
    }

    public String getDvdLength() {
        return dvdLength;
    }

    public String getDvdSpeed() {
        return dvdSpeed;
    }

    public double getDvdPrice() {
        return dvdPrice;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.dvdId);
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
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.dvdId, other.dvdId)) {
            return false;
        }
        return true;
    }
    
    
}
