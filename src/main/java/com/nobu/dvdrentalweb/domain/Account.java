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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nobu
 */
@Entity 
public class Account implements Serializable 
{
    private static final long serialVersionUID = 1L;
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Id
    private Long accountId;
    private String accountType;
    private String accountName;
   @Embedded
    private Payment pay;

    private Account()
    {
    }
    
    private Account(Builder builder)
    {
        accountId = builder.accountId;
        accountType = builder.accountType;
        accountName = builder.accountName;
       pay = builder.pay;
    }

    public double getAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static class Builder
    {
        private Long accountId;
        private String accountType;
        private String accountName;
        private Payment pay;
        public Builder()
        {
        }
        public Builder accountId(Long value)
        {
            accountId = value;
            return this;
        }
        
        public Builder accountType(String value)
        {
            accountType = value;
            return this;
        }
        public Builder accountName(String value)
        {
            accountName = value;
            return this;
        }
        public Builder pay(Payment value)
        {
            pay = value;
            return this;
        }
        public Builder account(Account value)
        {
            accountId = value.getAccountId();
            accountType = value.getAccountType();
            accountName = value.getAccountName();
            pay = value.getPay();
            return this;
        }
        public Account build()
        {
            return new Account(this);
        }
    }
    public Long getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public Payment getPay() {
        return pay;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.accountId, other.accountId)) {
            return false;
        }
        return true;
    }
    
    
    
}
