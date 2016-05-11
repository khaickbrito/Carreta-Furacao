/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.RmiServer;

/**
 *
 * @author victor
 */
public class Cliente {
    
    private RmiServer cliente;
    private Train trem;
    
    public Cliente(RmiServer c){
        this.cliente = c;
    }

    public RmiServer getCliente() {
        return cliente;
    }

    public Train getTrem() {
        return trem;
    }
    
    
    
}
