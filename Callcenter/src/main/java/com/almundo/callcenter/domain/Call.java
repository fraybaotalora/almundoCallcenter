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
public class Call extends Identifier {
    
    private final long time;
    
     /**
     * Metodo constructor de la clase Call
     * @param id identificador de la llamada
     * @param time tiempo de duracion de la llamada
     */
    public Call(long id, long time) {
        super(id);
        this.time=time;
    }
    /**
     *  Metodo permite obtener el tiempo de duracion de la llamada    
     * @return el tiempo que dura la llamada
    */
   public long getTime(){
       return this.time;
   } 
}
