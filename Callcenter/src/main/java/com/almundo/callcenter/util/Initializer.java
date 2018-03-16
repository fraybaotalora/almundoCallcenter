/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.util;

import com.almundo.callcenter.domain.Employee;
import com.almundo.callcenter.domain.TypeEmployee;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Logger;

/**
 *
 * @author frayotto
 */
public class Initializer {

    private final static Logger logger = Logger.getLogger(Initializer.class.getName());

    public Initializer() {
    }

    public PriorityBlockingQueue crearEmpleados() {
        logger.info("Iniciando proceso de creacion de empleados");
        Util util = new Util();
        PriorityBlockingQueue<Employee> myEmpleados = new PriorityBlockingQueue<>(6, Comparator.comparing(Employee::getTipo));

        myEmpleados.add(new Employee(util.getIdandIncrement(), TypeEmployee.SUPERVISOR));
        myEmpleados.add(new Employee(util.getIdandIncrement(), TypeEmployee.OPERADOR));
        myEmpleados.add(new Employee(util.getIdandIncrement(), TypeEmployee.DIRECTOR));
        myEmpleados.add(new Employee(util.getIdandIncrement(), TypeEmployee.SUPERVISOR));
        myEmpleados.add(new Employee(util.getIdandIncrement(), TypeEmployee.OPERADOR));
        myEmpleados.add(new Employee(util.getIdandIncrement(), TypeEmployee.OPERADOR));

        
         logger.info("Finaliza proceso de creacion de empleados");
        return myEmpleados;
    }
}
