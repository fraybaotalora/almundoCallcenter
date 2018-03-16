/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.domain;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author frayotto
 */
public class Identifier {
     
    private final long id;
    
    
    public Identifier(long id){
        this.id=id;
    }
    
    
    public long getId(){
     return this.id;
    }
    
}
