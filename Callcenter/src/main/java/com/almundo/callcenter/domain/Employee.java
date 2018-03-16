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
public class Employee extends Identifier{
    
    private final TypeEmployee tipo;
    
    public Employee(long id,TypeEmployee tipo){
       super(id);
       this.tipo=tipo;
       
    }
    
    public TypeEmployee getTipo(){
      return this.tipo;
    }
    
    
    
    
    
}
