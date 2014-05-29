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
public class Admin implements Serializable
{
    public static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;
    private String stations;
    private String password;

     private Admin()
    {
    }
    
    private Admin(Builder builder)
    {
        adminId = builder.adminId;
        stations = builder.stations;
        password = builder.password;
        
       
    }
    public static class Builder
    {
        private Long adminId;
        private String stations;
        private String password;
        
        
        public Builder()
        {
        }
        public Builder adminId(Long value)
        {
            adminId = value;
            return this;
        }
        
        public Builder stations(String value)
        {
            stations = value;
            return this;
        }    
        public Builder password(String value)
        {
            password = value;
            return this;
        } 
        public Builder admin(Admin value)
        {
            adminId = value.getAdminId();
            stations = value.getStations();
            password = value.getPassword();
           
            return this;
        }
        public Admin build()
        {
            return new Admin(this);
        }
    }
    public Long getAdminId() {
        return adminId;
    }

    public String getStations() {
        return stations;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.adminId);
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
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.adminId, other.adminId)) {
            return false;
        }
        return true;
    }
    
    
   
}
