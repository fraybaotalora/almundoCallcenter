/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.domain;


/**
 *
 * @author Frayba otalora
 */
public class Employee extends Identifier{
    
    private final TypeEmployee tipo;
    
    /**
     * Metodo constructor de la clase Call
     * @param id identificador del empleado
     * @param tipo rol del empleado dentro del callcenter
     */
    public Employee(long id,TypeEmployee tipo){
       super(id);
       this.tipo=tipo;
       
    }
    
    /**
     * Metodo encargado de devolver el rol del empleado
     * @return tipo  rol del empleado en el callcenter
     */
    public TypeEmployee getTipo(){
      return this.tipo;
    }
    
    
    
    
    
}
