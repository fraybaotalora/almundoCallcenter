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
 * @author Frayba otalora
 */
public class Util {

    private final AtomicLong id = new AtomicLong();

    /**
     * Metodo constructor de la clase Util
     */
    public Util() {
    }

      /**
     * Metodo encargado de obtener el valor actual de la variable id de tipo AtomicLong
     * @return valor actual de variable id
     */
    public long getId() {
        return this.id.get();
    }

    /**
     * Metodo encargado de incrementar en 1 el valor actual de la variable id de tipo AtomicLong
     * @return valor actual de la variable id+1
     */
    public long getIdandIncrement() {
        return this.id.incrementAndGet();
    }

    /**
     * Metodo encargado generar un numero randomico entre dos rangos establecidos por el usuario
     * @param max valor maximo  que puede tener el numero generado
     * @param min valor minimo que puede tener el numero generado
     * @return numero aleatorio entre rangos establecidos
     */
    public int randomicoTiempo(int max, int min) {

        if (min >= max) {
            throw new IllegalArgumentException("Los valores no cumplen las condiciones para generar un randomico valido");
        }

        Random r = new Random();
        return ((r.nextInt((max - min) + 1) + min));
    }

}
