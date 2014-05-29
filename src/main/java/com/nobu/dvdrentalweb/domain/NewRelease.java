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
public class NewRelease implements Serializable 
{
      public static final long serialVersionUID = 1L;
         @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private  Long newid;
        private  boolean newavail;
        private int yearofrelease;
        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "newRelease_id")
        List <Movie> movie;
    
        
    private NewRelease() 
    {
    }
    
    private NewRelease(Builder builder)
    {
        newid = builder.newid;
        newavail = builder.newavail;
        yearofrelease = builder.yearofrelease;
        movie = builder.movie;
    }
    public static class Builder
    {
        private  Long newid;
        private  boolean newavail;
        private int yearofrelease;
        List<Movie> movie;
       
        public Builder()
        {
         
        }
        public Builder newid(Long value)
        {
            newid = value;
            return (this);
            
        }
        public Builder yearofrelease(int value)
        {
            yearofrelease = value;
            return this;
        }
        public Builder newavail(boolean value)
        {
            newavail = value;
            return this;
        }
         public Builder movie(List<Movie> value)
        {
            movie = value;
            return this;
        }
        public Builder newRelease(NewRelease value)
        {
            newid = value.getNewid();
            yearofrelease = value.getYearofrelease();
            newavail = value.isNewavail();
            movie = value.getMovie();
            return this;
        }
     
        public NewRelease build()
        {
            return new NewRelease(this);
        }
    }

        public Long getNewid() {
            return newid;
        }

        public boolean isNewavail() {
            return newavail;
        }

    public List<Movie> getMovie() {
        return movie;
    }

        public int getYearofrelease() {
            return yearofrelease;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 73 * hash + Objects.hashCode(this.newid);
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
            final Builder other = (Builder) obj;
            if (!Objects.equals(this.newid, other.newid)) {
                return false;
            }
            return true;
        }
        
        
        
    }

