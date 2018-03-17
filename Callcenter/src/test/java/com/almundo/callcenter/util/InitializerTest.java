/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.util;

import com.almundo.callcenter.domain.Employee;
import java.util.concurrent.PriorityBlockingQueue;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author frayotto
 */
public class InitializerTest {
    
    private final Initializer inicializador= new Initializer();
    
    public InitializerTest() {
    }
    
   @Test
   public void colaNoVacia(){
   PriorityBlockingQueue<Employee> empleados= inicializador.crearEmpleados();
   Assert.assertNotNull(empleados);
   }

    
}
