/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TremController;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RmiServer extends UnicastRemoteObject implements RmiServerInterface{  
    private TremController controller;
    
    public RmiServer() throws RemoteException{
        // construtor padrão
        this.controller = TremController.getInstance();  
    }  

    /*
        Serve para enviar a própria posição para os trens vizinhos.
    */
    @Override
    public boolean sendSelfDistance(double dist) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
        Serve para enviar a sua própria posição para os trens vizinhos.
    */
    @Override
    public void sendSelfPosition(int id, int x, int y) throws RemoteException {
        controller.changePosition(id, x, y);
    }
    /*
        Serve para um trem envir sua própria velocidade para os outros, assim 
    eles ficarão sabendo de sua velocidade atual.
    */
    @Override
    public boolean sendSelfVelocity(int id, int veloc) throws RemoteException {
        return controller.changeSpeed(id, veloc);
    }

    /*
        Serve para alterar a velocidade do trem portador desse registro aqui.
    */
    @Override
    public boolean changeTrainVelocity(int newVeloc) throws RemoteException {
        controller.changeSpeed(facade.getMyId(), newVeloc);
        return true;
    }
    
    /*
        Serve para enviar para o trem portador desse registro a velocidade máxi-
    ma que ele pode trafegar sem invadir a zona compartilhada.
    */
    @Override
    public boolean sendMaxSpeed(int Maxspeed) throws RemoteException {
        return controller.changeMaxSpeed(facade.getMyId(), Maxspeed);
    }
    
    @Override
    public String[] getTrainsIp() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}