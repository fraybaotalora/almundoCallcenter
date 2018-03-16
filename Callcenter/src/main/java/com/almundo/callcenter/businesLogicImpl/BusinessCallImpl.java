/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.businesLogicImpl;

import com.almundo.callcenter.businessLogic.BusinessCall;
import com.almundo.callcenter.businessLogic.Dispatcher;
import com.almundo.callcenter.domain.Call;
import com.almundo.callcenter.util.Util;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frayba otalora
 */
public class BusinessCallImpl extends BusinessThreadImpl implements BusinessCall {
    
     private final static Logger logger = Logger.getLogger(BusinessCallImpl.class.getName());
    private static final int TIEMPO_MAX_LLAMADA=10;
    private static final int TIEMPO_MIN_LLAMADA=5;
    private static final int TIEMPO_CREAR_LLAMADA=100;
    private static final int TIEMPO_RETRASO_LLAMADA=0;
    private final Dispatcher dispatcher=null;
    
    
    public BusinessCallImpl(int tamañoPool) {
        super(tamañoPool);
    }
    

    @Override
    public void realizarLlamada(Dispatcher dispatcher) {
        logger.warning("Iniciando proceso de llamadas");
        Util util=new Util();
        
        this.threadPool.scheduleAtFixedRate(() -> {
            //crea una llamada y la transfiere al area de operadores
            Call llamada= new Call(util.getIdandIncrement(),util.randomicoTiempo(TIEMPO_MAX_LLAMADA, TIEMPO_MIN_LLAMADA));
            logger.log(Level.INFO, "Creando llamada: {0} con duracion: {1}", new Object[]{llamada.getId(),llamada.getTime()});
            dispatcher.dispatcherCall(llamada);
             
         }, 
        TIEMPO_RETRASO_LLAMADA, 
        TIEMPO_CREAR_LLAMADA, 
        TimeUnit.MILLISECONDS);
       
    }
    

    @Override
    public void pararLlamadas() {
         logger.info("Deteniendo produccion de llamadas");
        super.stop();
    }
 
}
