/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Embedded;
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
public class Movie implements Serializable
{
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;
    private String producer;
    private int movielength;
    private int numberOfCopies;
    private boolean status;
   // private int agerestriction;
    private String moviename;
    @Embedded 
    private Genre genre;
    @Embedded
    private RentDate rent;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    List <Dvd> dvd;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    List <BlueRay> blue;
    

    private Movie()
    {
    }
    
    private Movie(Builder builder)
    {
        movieId = builder.movieId;
        producer = builder.producer;
        movielength = builder.movielength;
        numberOfCopies = builder.numberOfCopies;
        status = builder.status;
        genre = builder.genre;
        rent = builder.rent;
        dvd = builder.dvd;
        blue = builder.blue;
        //agerestriction = builder.agerestriction;
        moviename = builder.moviename;
       
    }
    public static class Builder
    {
        private Long movieId;
        private String producer;
        private int movielength;
        private int numberOfCopies;
        private boolean status;
        private String moviename;
        @Embedded
        private Genre genre;
       // private int agerestriction;
        @Embedded
        private RentDate rent;
        private List <Dvd> dvd;
        private List <BlueRay> blue;
        
        public Builder()
        {
        }
        
        public Builder movieId(Long value)
        {
            movieId = value;
            return this;
        }
        
        public Builder producer(String value)
        {
            producer = value;
            return this;
        }
        public Builder movielength(int value)
        {
            movielength = value;
            return this;
        }
        public Builder numberOfCopies(int value)
        {
            numberOfCopies = value;
            return this;
        }
        public Builder status(boolean value)
        {
            status = value;
            return this;
        }
        public Builder moviename(String  value)
        {
            moviename = value;
            return this;
        }
        public Builder rent(RentDate value)
        {
            rent = value;
            return this;
        }
         public Builder dvd(List <Dvd> value)
        {
            dvd = value;
            return this;
        }
          public Builder genre(Genre value)
        {
            genre = value;
            return this;
        }
           public Builder blue(List <BlueRay> value)
        {
            blue = value;
            return this;
        }
//           public Builder agerestriction(int value)
//           {
//               agerestriction = value;
//               return this;
//           }
        public Builder account(Movie value)
        {
            movieId = value.getMovieId();
            producer = value.getProducer();
            movielength = value.getLength();
            numberOfCopies = value .getNumberOfCopies();
            status = value.isStatus();
            genre = value.getGenre();
            rent = value.getRent();
            dvd = value.getDvd();
            blue = value.getBlue();
            //agerestriction = value.getAgerestriction();
            moviename = value.getMoviename();
            return this;
        }
        public Movie build()
        {
            return new Movie(this);
        }
    }
    public Long getMovieId() {
        return movieId;
    }

    public String getProducer() {
        return producer;
    }

    public int getLength() {
        return movielength;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public boolean isStatus() {
        return status;
    }

    public Genre getGenre() {
        return genre;
    }

    public RentDate getRent() {
        return rent;
    }

   

//    public int getAgerestriction() {
//        return agerestriction;
//    }

    public List <Dvd> getDvd() {
        return dvd;
    }

    public List <BlueRay> getBlue() {
        return blue;
    }

    public String getMoviename() {
        return moviename;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.movieId);
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
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.movieId, other.movieId)) {
            return false;
        }
        return true;
    }
    
}
