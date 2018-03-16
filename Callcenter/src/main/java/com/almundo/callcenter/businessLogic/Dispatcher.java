/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.businessLogic;

import com.almundo.callcenter.domain.Call;

/**
 *
 * @author frayotto
 */
public interface Dispatcher {
    
    void dispatcherCall(Call llamada);
    
}
