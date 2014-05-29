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
public class Address implements Serializable
{
   /// private Long addressId;
    private String streetName;
    private int houseNumber;
    private String location;

    private Address()
    {
    }
    
    private Address(Builder builder)
    {
        //addressId = builder.addressId;
        streetName = builder.streetName;
        houseNumber = builder.houseNumber;
        location = builder.location;
       
    }
    public static class Builder
    {
        //private Long addressId;
        private String streetName;
        private int houseNumber;
        private String location;
        
        public Builder()
        {
        }
//        public Builder addressId(Long value)
//        {
//            addressId = value;
//            return this;
//        }
//        
        public Builder streetName(String value)
        {
            streetName = value;
            return this;
        }
        public Builder houseNumber(int value)
        {
            houseNumber = value;
            return this;
        }
        public Builder location(String value)
        {
            location = value;
            return this;
        }
        public Builder address(Address value)
        {
            //addressId = value.getAddressId();
            streetName = value.getStreetName();
            houseNumber = value.getHouseNumber();
            location = value.getLocation();
            return this;
        }
        public Address build()
        {
            return new Address(this);
        }
    }

//    public Long getAddressId() {
//        return addressId;
//    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getLocation() {
        return location;
    }   
}
