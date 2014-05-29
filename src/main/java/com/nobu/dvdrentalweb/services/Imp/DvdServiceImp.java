/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nobu.dvdrentalweb.services.Imp;

import com.nobu.dvdrentalweb.domain.Dvd;
import com.nobu.dvdrentalweb.services.DvdCostService;
import java.util.List;

/**
 *
 * @author nobu
 */
public class DvdServiceImp implements DvdCostService {
    public int count;
    
    @Override
    public Dvd highestCost(List<Dvd> dvd)
    {
        double highest = dvd.get(0).getDvdPrice();
        
        for(int i = 1; i < dvd.size(); i++){
             if(dvd.get(i).getDvdPrice() < highest){
                 highest = dvd.get(i).getDvdPrice();
                 count = i;
             }
        }
       return dvd.get(count);
    }
    
}
