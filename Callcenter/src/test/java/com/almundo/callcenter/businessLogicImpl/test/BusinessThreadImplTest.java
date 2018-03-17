/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.businessLogicImpl.test;

import com.almundo.callcenter.businesLogicImpl.BusinessThreadImpl;
import com.almundo.callcenter.businessLogic.BusinessThread;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author frayotto
 */
public class BusinessThreadImplTest {
    
    private BusinessThread threadPool;
    
    public BusinessThreadImplTest() {
    }
    
   @Test
   public void crearPool10Conexiones(){
   
       this.threadPool=new BusinessThreadImpl(10);
       Assert.assertTrue(this.threadPool.corriendo());
       
   }
    
   
   @Test
   public void detenerThreadPool(){
        this.threadPool=new BusinessThreadImpl(10);
        this.threadPool.detener();
        Assert.assertTrue(!this.threadPool.corriendo());
   }
    
}
