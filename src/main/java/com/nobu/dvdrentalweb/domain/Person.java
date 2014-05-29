/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
public class Person implements Serializable
{
      private static final long serialVersionUID = 1L;
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Id
     
    private Long Id;
    private String firstname;
    private String lastname;
    private int age;
    @Embedded
    private Contact contact;
    @Embedded 
    private Address address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    List<Account> account;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    List<Subscription> sub;
    
      private Person()
    {
    }
    
    private Person(Builder builder)
    {
        Id = builder.Id;
        firstname = builder.firstname;
        lastname = builder.lastname;
         age = builder.age;
         contact = builder.contact;
         account = builder.accounts;
         sub = builder.sub;
         address = builder.address;
        
       
    }
  public static class Builder
    {
        private Long Id;
        private String firstname;
        private String lastname;
        private int age; 
        public Contact contact;
        List<Account> accounts;
        List<Subscription > sub;
        private Address address;
        
    
        
        public Builder()
        {
        }
        public Builder Id(Long value)
        {
            Id = value;
            return this;
        }
        
        public Builder firstname(String value)
        {
            firstname = value;
            return this;
        }
        public Builder lastname(String value)
        {
            lastname = value;
            return this;
        }
        public Builder age(int value)
        {
            age = value;
            return this;
        }
        public Builder contact(Contact value)
        {
            contact = value;
            return this;
        } 
        public Builder address(Address value)
        {
            address = value;
            return this;
        }
        public Builder account(List<Account> value)
        {
            accounts = value;
            return this;
        }
        public Builder sub(List<Subscription> value)
        {
            sub = value;
            return this;
        }
        public Builder person(Person value)
        {
            Id = value.getId();
            firstname = value.getFirstname();
            lastname = value.getLastname();
            age = value.getAge();
            contact = value.getContact();
            sub= value.getSub();
            address = value.getAddress();
            accounts = value.getAccount();
            return this;
        }
        public Person build()
        {
            return new Person (this);
        }
    }
    public Long getId() {
        return Id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public List<Account> getAccount() {
        return account;
    }

    public List<Subscription> getSub() {
        return sub;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Id);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
}
