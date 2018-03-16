/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.businesLogicImpl;

import com.almundo.callcenter.businessLogic.BusinessThread;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

/**
 *
 * @author frayotto
 */
public class BusinessThreadImpl implements BusinessThread {

    private final static Logger logger = Logger.getLogger(BusinessThreadImpl.class.getName());
    ScheduledExecutorService threadPool;

    public BusinessThreadImpl(int tamañoPool) {
        logger.info("Estableciendo pool de conexiones");
        threadPool = Executors.newScheduledThreadPool(tamañoPool);
    }

    /**
     * Metodo utilizado para conocer si el hilo todavia se encuentra en
     * ejecucion
     *
     * @return true en caso de que se el hilo se encuentre en ejecucion, Falso
     * en caso contrario.
     */
    public Boolean isRunning() {
        return !this.threadPool.isTerminated();
    }

    /**
     * Metodo utilizado para detener el hilo
     */
    public void stop() {
        this.threadPool.shutdown();
    }

}
