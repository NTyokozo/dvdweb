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
public class Genre implements Serializable 
{
   //private Long genId;
    private String genType;
    
      
    private Genre()
    {
    }
    
    private Genre(Builder builder)
    {
      //  genId = builder.genId;
        genType = builder.genType;
 
    }
     public static class Builder
    {
       // private Long genId;
        private String genType;
    
        
        public Builder()
        {
        }
//        public Builder dvdId(Long value)
//        {
//         //   genId = value;
//            return this;
//        }
        
        public Builder genType(String value)
        {
            genType = value;
            return this;
        }
        public Builder genre(Genre value)
        {
          //  genId = value.getGenId();
            genType = value.getGenType();
        
            return this;
        }
        public Genre build()
        {
            return new Genre (this);
        }
    }

//    public Long getGenId() {
//        return genId;
//    }

    public String getGenType() {
        return genType;
    }

    
}
