/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.util;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author frayotto
 */
public class Util {
    
    private AtomicLong id= new AtomicLong();
    
    
    public Util(){
    }
    
    
    public long getId(){
    return this.id.get();
    }
    
    public long getIdandIncrement(){
        return this.id.incrementAndGet();
    }
    
    
    public int randomicoTiempo(int max, int min){
        Random r = new Random();
        return ((r.nextInt((max - min) + 1) + min));
    }
    
    
    
}
