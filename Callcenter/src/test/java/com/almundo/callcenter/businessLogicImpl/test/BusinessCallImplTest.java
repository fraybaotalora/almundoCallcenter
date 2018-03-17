/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.businessLogicImpl.test;

import com.almundo.callcenter.App.MainApp;
import com.almundo.callcenter.businesLogicImpl.BusinessCallImpl;
import com.almundo.callcenter.businesLogicImpl.DispatcherImpl;
import com.almundo.callcenter.businessLogic.BusinessCall;
import com.almundo.callcenter.businessLogic.Dispatcher;
import com.almundo.callcenter.domain.Call;
import com.almundo.callcenter.util.Initializer;
import com.almundo.callcenter.util.Util;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author frayotto
 */
public class BusinessCallImplTest {
    
    private final static Logger logger = Logger.getLogger(BusinessCallImplTest.class.getName());
    private final Initializer inicializar=new Initializer();
    private final  BusinessCall llamada =new BusinessCallImpl(10);;
    private final Dispatcher dispatcher =new DispatcherImpl(inicializar.crearEmpleados());;
    private final  ArrayList<Call>  myLlamada=new ArrayList();
    
    
    public BusinessCallImplTest() {
    }
   
    
    @Test
    public void crear10Llamadas(){
        Util util=new Util();
        for(int i=0; i<10;i++){
          this.myLlamada.add(new Call(util.getIdandIncrement(),util.randomicoTiempo(10, 5)));
        }
        Assert.assertEquals(10, myLlamada.get(myLlamada.size()-1).getId());
    }
    
  
    @Test
    public void realizar10Llamadas(){
        logger.info("Realizando 10 llamadas");
        this.crear10Llamadas();
        myLlamada.parallelStream().forEach(dispatcher::dispatcherCall);
   
          try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void realizar20Llamadas(){
        logger.info("Realizando 20 llamadas");
        this.crear20Llamadas();
        myLlamada.parallelStream().forEach(dispatcher::dispatcherCall);
         try {
            TimeUnit.SECONDS.sleep(200);
        } catch (InterruptedException ex) {
          
        }
         
         this.llamada.pararLlamadas();
        
    }
    
    
    
      public void crear20Llamadas(){
        Util util=new Util();
        for(int i=0; i<20;i++){
          this.myLlamada.add(new Call(util.getIdandIncrement(),util.randomicoTiempo(10, 5)));
        }
        Assert.assertEquals(50, myLlamada.get(myLlamada.size()-1).getId());
    }
    
   
    
}
