/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.restapi;


import com.nobu.dvdrentalweb.domain.Person;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

/**
 *
 * @author hashcode
 */
public class PersonRestControllerTest {
    private RestTemplate restTemplate;
    private final static String URL = "http://localhost:8084/dvdrentalweb/";
    
    
    @Test
    public void tesCreate(){
        Person p = new Person.Builder().firstname("nobu").age(5).build();
        HttpEntity<Person> requestEntity = new HttpEntity<>(p, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL+"api/person/create", HttpMethod.POST, requestEntity, String.class);

     
        
    }
    
    
    public void testRead(){
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Person[]> responseEntity = restTemplate.exchange("URL",HttpMethod.GET,requestEntity, Person[].class);
        
        Person [] people = responseEntity.getBody();
        for (Person person : people) {
            
            
        }
       
    }
    
    private HttpEntity<?> getHttpEntity(){
         HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }
    
}
