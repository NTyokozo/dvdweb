/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.restapi;

import com.nobu.dvdrentalweb.domain.Account;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author nobu
 */
public class AccountRestControllerTest {
    
    public AccountRestControllerTest() {
    }

     private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8084/dvdrentalweb/";

  @Test
    public void tesCreate() {
        Account account = new Account.Builder().accountName("Savings").accountType("Gold Card").build();
        HttpEntity<Account> requestEntity = new HttpEntity<>(account, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/account/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void tesAcountsUpdate() {
       
        Account account = new Account.Builder().accountName("Savings").accountType("Gold Card").build();
        HttpEntity<Account> requestEntity = new HttpEntity<>(account, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/account/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    public void testreadClubByNameName() {
       String accountName = "Savings";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Account> responseEntity = restTemplate.exchange(URL + "api/account/name/" + accountName, HttpMethod.GET, requestEntity, Account.class);
        Account account = responseEntity.getBody();

        Assert.assertNotNull(account);

    }

    @Test
    public void testreadAcountsClubById() {
       String accountName = "Savings";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Account> responseEntity = restTemplate.exchange(URL + "api/account/name/" + accountName, HttpMethod.GET, requestEntity, Account.class);
        Account account = responseEntity.getBody();

        Assert.assertNotNull(account);

    }

    @Test
    public void testgetAllAcounts() {
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Account[]> responseEntity = restTemplate.exchange(URL + "api/account/accounts", HttpMethod.GET, requestEntity, Account[].class);
        Account[] accounts = responseEntity.getBody();
        for (Account account : accounts) {
            System.out.println("The Account Name is " + account.getAccountName());

        }

        Assert.assertTrue(accounts.length > 0);
    }

    private HttpEntity<?> getHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }

    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }

}
