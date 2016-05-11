/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.RmiServer;
import Util.RmiServerInterface;

/**
 *
 * @author victor
 */
public class Cliente {
    
    private RmiServerInterface cliente;
    private Train trem;
    
    public Cliente(RmiServerInterface c){
        this.cliente = c;
    }

    public RmiServerInterface getCliente() {
        return cliente;
    }

    public Train getTrem() {
        return trem;
    }
    
    
    
}
