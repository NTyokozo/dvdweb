/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.repository;

import com.nobu.dvdrentalweb.domain.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nobu
 */
public interface DvdRepository extends JpaRepository<Dvd, Long> {
    
}
