/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.App;

import com.almundo.callcenter.businesLogicImpl.BusinessCallImpl;
import com.almundo.callcenter.businesLogicImpl.DispatcherImpl;
import com.almundo.callcenter.businessLogic.BusinessCall;
import com.almundo.callcenter.businessLogic.Dispatcher;
import com.almundo.callcenter.util.Initializer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frayba otalora
 */
public class MainApp {

    private final static Logger logger = Logger.getLogger(MainApp.class.getName());
    private BusinessCall llamadas;
    private Dispatcher dispatcher;
    private long  cantidadLlamadas;
    private static final int TAMAÑO_POOL = 10;
 

    public static void main(String[] x) {

        MainApp main = new MainApp();

        main.setCantidadLlamadas(10);
        main.inicilizarDatos();
        main.realizarLlamadas();
        
    }
    
    /**

     * Metodo para establecer la cantidad de llamadas a realizar
     * @param cantidadLlamadas  cantidad de llamadas segun requerimiento
     */
    public void setCantidadLlamadas(long cantidadLlamadas){
        this.cantidadLlamadas=cantidadLlamadas;
    }

    /*
    *Metodo encargado de inicializar los empleados a los cuales se le van a asignar las llamadas.
    *Este metodo utiliza la clase Initializer para poder crear los empleados correspondientes
    */
    public void inicilizarDatos() {
        logger.info("Iniciando llenado de datos");
        // se instancia el despachador de llamadas y se le asigna una cola de prioridad con empleados 
        this.dispatcher = new DispatcherImpl(new Initializer().crearEmpleados());
    }

    
     /*
    *Metodo encargado de inicializar los empleados a los cuales se le van a asignar las llamadas.
    *Este metodo utiliza la clase Initializer para poder crear los empleados correspondientes
    */
    public void realizarLlamadas() {
        logger.info("Estableciendo parametros para inicializar llamadas");
        //se intancia el manejador de las llamadas a realizar.  
        this.llamadas = new BusinessCallImpl(TAMAÑO_POOL);

        //se inicia la produccion de llamadas
        this.llamadas.realizarLlamada(dispatcher);

        //el hilo que se ejecuta, se ponde a dormir segun la cantidad de llamadas requeridas. Para nuesto caso son 10
        try {
            TimeUnit.MILLISECONDS.sleep(this.cantidadLlamadas*100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //se detiene el proceso de produccion de llamadas
        this.llamadas.pararLlamadas();
    }

}
