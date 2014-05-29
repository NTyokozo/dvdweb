/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author nobu
 */
@Entity
public class OldRelease implements Serializable
{
      public static final long serialVersionUID = 1L;
         @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
         private  Long oldid;
        private  boolean oldavail;
        private int oldyearofrelease;
        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "newRelease_id")
        List <Movie> movie;
    
    
        
    private OldRelease() 
    {
    }
    
    private OldRelease(Builder builder)
    {
        oldid = builder.oldid;
        oldavail = builder.oldavail;
        oldyearofrelease = builder.oldyearofrelease;
             movie = builder.movie;
    }
    public static class Builder
    {
        private  Long oldid;
        private  boolean oldavail;
        private int oldyearofrelease;
        List<Movie> movie;
       
        public Builder()
        {
         
        }
        public Builder newid(Long value)
        {
            oldid = value;
            return (this);
            
        }
        public Builder yearofrelease(int value)
        {
            oldyearofrelease = value;
            return this;
        }
        public Builder oldavail(boolean value)
        {
            oldavail = value;
            return this;
        }
        public Builder oldRelease(OldRelease value)
        {
            oldid = value.getOldid();
            oldyearofrelease = value.getYearofrelease();
            oldavail = value.isOldavail();
            movie = value.getMovie();
            return this;
        }
        public Builder movie(List<Movie> value)
        {
            movie = value;
            return this;
        }
        public OldRelease build()
        {
            return new OldRelease(this);
        }
    }

    public Long getOldid() {
        return oldid;
    }

    public boolean isOldavail() {
        return oldavail;
    }

    public int getYearofrelease() {
        return oldyearofrelease;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.oldid);
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
        final OldRelease other = (OldRelease) obj;
        if (!Objects.equals(this.oldid, other.oldid)) {
            return false;
        }
        return true;
    }

    
}
