/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.businessLogic;

/**
 *
 * @author Frayba otalora
 */
public interface BusinessCall {
    
    void realizarLlamada(Dispatcher dispatcher);
    
    void pararLlamadas();
    
}
