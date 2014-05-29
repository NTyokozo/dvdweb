/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.repository;

import com.nobu.dvdrentalweb.domain.OldRelease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nobu
 */
@Repository
public interface OldReleaseRepository extends JpaRepository<OldRelease , Long> {
    
}
