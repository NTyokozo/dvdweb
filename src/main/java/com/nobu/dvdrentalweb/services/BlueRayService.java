/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services;

import com.nobu.dvdrentalweb.domain.BlueRay;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author nobu
 */
@Service
public interface BlueRayService {
    
    public BlueRay highestCost(List<BlueRay> blue);
    
}
