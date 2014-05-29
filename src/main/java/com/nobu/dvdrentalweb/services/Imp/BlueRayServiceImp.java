/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services.Imp;

import com.nobu.dvdrentalweb.domain.BlueRay;
import com.nobu.dvdrentalweb.services.BlueRayService;
import java.util.List;

/**
 *
 * @author nobu
 */
public class BlueRayServiceImp  implements BlueRayService {
    public int count;
    
    @Override
    public BlueRay highestCost(List<BlueRay> blue)
    {
        double highest = blue.get(0).getPrice();
        
        for(int i = 1; i < blue.size(); i++){
             if(blue.get(i).getPrice() < highest){
                 highest = blue.get(i).getPrice();
                 count = i;
             }
        }
       return blue.get(count);
    }
    
}
