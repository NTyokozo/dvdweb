/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.test.restapi;

import com.nobu.dvdrentalweb.domain.Movie;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
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
public class MovieRestControllerTest {
    
    public MovieRestControllerTest() {
    }
    private RestTemplate restTemplate;
    private static final String URL = "http://localhost:8084/dvdrentalweb/";

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createTest()
     {
        Movie movie = new Movie.Builder().moviename("Set it off").build();
         HttpEntity<Movie> requestEntity = new HttpEntity<>(movie , getContentType());
         ResponseEntity<String> responseEntity = restTemplate.
                 exchange(URL+"api/movie/create", HttpMethod.POST, requestEntity, String.class);
     }
     
     public void readTest()
     {
         HttpEntity<?> requestEntity = getHttpEntity();
         ResponseEntity<Movie[]> responseEntity =  restTemplate.exchange(URL, HttpMethod.GET, requestEntity, Movie[].class);
         
         Movie[] movie = responseEntity.getBody();
         
         for(Movie movies : movie)
         {
         }
     }
     
     private HttpEntity<?> getHttpEntity()
     {
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
