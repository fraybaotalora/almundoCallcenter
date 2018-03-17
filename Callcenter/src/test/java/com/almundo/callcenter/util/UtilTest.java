/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.util;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author frayotto
 */
public class UtilTest {

    private final Util util = new Util();

    public UtilTest() {
    }

    @Test
    public void comporbarIncrementoAtomicLong() {
        long atomic = 0;
        int i;
        for (i = 0; i < 10; i++) {
            atomic = util.getIdandIncrement();
        }
        Assert.assertEquals(10, atomic);

    }

    @Test
    public void generarRandomicoValido() {
        int random = util.randomicoTiempo(10, 5);
        Assert.assertTrue((random >= 5 && random <= 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generarRandomicoInvalido() {
        util.randomicoTiempo(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generarRandomicoInvalidoMinMayorMax() {
        util.randomicoTiempo(5, 10);
    }

    
}
