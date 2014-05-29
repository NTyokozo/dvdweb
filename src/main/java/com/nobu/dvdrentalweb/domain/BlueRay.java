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
public class BlueRay implements Serializable
{
    public static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bluerayId;
    private String blueSpeed;
    private String visual; 
    private double price;
    
      private BlueRay()
    {
    }
    
    private BlueRay(Builder builder)
    {
        bluerayId = builder.bluerayId;
        blueSpeed = builder.blueSpeed;
        visual = builder.visual;
        price = builder.price;
       
    }

    public double getPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static class Builder
    {
        private Long bluerayId;
        private String blueSpeed;
        private String visual;
        private double price;
        
        public Builder()
        {
        }
        public Builder bluerayId(Long value)
        {
            bluerayId = value;
            return this;
        }
         public Builder bluePrice(double value)
        {
            price = value;
            return this;
        }
        
        public Builder blueSpeed(String value)
        {
            blueSpeed = value;
            return this;
        }
        public Builder visual(String value)
        {
            visual = value;
            return this;
        }
        public Builder blueRay(BlueRay value)
        {
            bluerayId = value.getBluerayId();
            blueSpeed = value.getBlueSpeed();
            visual = value.getVisual();
            price = value.getBluePrice();
            return this;
        }
        public BlueRay build()
        {
            return new BlueRay(this);
        }
    }

    public Long getBluerayId() {
        return bluerayId;
    }

    public String getBlueSpeed() {
        return blueSpeed;
    }

    public String getVisual() {
        return visual;
    }
    
    public double getBluePrice()
    {
        return price;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.bluerayId);
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
        final BlueRay other = (BlueRay) obj;
        if (!Objects.equals(this.bluerayId, other.bluerayId)) {
            return false;
        }
        return true;
    }
    
    
}
