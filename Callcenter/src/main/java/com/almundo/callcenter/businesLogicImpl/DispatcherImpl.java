/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.businesLogicImpl;


import com.almundo.callcenter.businessLogic.Dispatcher;
import com.almundo.callcenter.domain.Call;
import com.almundo.callcenter.domain.Employee;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frayba otalora
 */
public class DispatcherImpl implements Dispatcher{
    
    private final static Logger logger = Logger.getLogger(DispatcherImpl.class.getName());
    PriorityBlockingQueue<Employee> myEmpleados;
    
    /**
     * Metodo constructor de la clase Dispatcher
     * @param empleados Una cola de prioridad con la cantidad de empleados establecidos para 
     * atender las llamadas que se generen
     */
    public DispatcherImpl(PriorityBlockingQueue<Employee> empleados){
        this.myEmpleados=empleados;
        
    }

    /**
     * Metodo encargado de asignar las llamadas recibidas a uno de los empleados
     * que se encuentran disponibles en la cola de prioridad.
     * @param llamada Llamada entrante para ser asignada.
     */
    @Override
    public void dispatcherCall(Call llamada) {
        logger.log(Level.INFO, "Entrando llamada: {0}", llamada.getId());
        new Thread(() -> {
            Employee e = null;
            try {
                e = this.myEmpleados.take();
                logger.log(Level.INFO, "Recibiendo llamada: {0} por:{1}", new Object[]{llamada.getId(), e.getTipo()});
                TimeUnit.MILLISECONDS.sleep(llamada.getTime()*1000);
                myEmpleados.put(e);
                logger.log(Level.INFO, "Termino llamada:{0} atendida por :{1}", new Object[]{llamada.getId(), e.getTipo()});

            } catch (InterruptedException exc) {
                logger.log(Level.SEVERE, "Ocurrio error al despachar las llamadas{0}", exc.getMessage());
            }
        }).start();
    
    }
    
 
}
