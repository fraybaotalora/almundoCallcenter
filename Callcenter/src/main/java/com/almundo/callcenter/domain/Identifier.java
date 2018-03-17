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
public class Identifier {

    //atributos de la clase identificador
    private final long id;

     /**
     * Metodo constructor
     * @param id  numero de identificacion otorgado al objeto
     */
    public Identifier(long id) {
        this.id = id;
    }

    /**
     * Metodo encargadop de devolver el identificador del objeto
     * @return id  numero de identificacion otorgado al objeto
     */
    public long getId() {
        return this.id;
    }

}
