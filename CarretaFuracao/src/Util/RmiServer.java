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
    
    @Override
    public int somar(int a, int b) throws RemoteException{
        return a + b;
    }    

    @Override
    public boolean sendDistance(double dist) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendSelfPosition(double x, double y) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendSelfVelocity(double veloc) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean changeTrainVelocity(int newVeloc) throws RemoteException {
        controller.changeSpeed(facade.getMyId(), newVeloc);
        return true;
    }

    @Override
    public boolean sendMaxSpeed(int Maxspeed) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendToken() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getTrainsIp() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printFuncionou() throws RemoteException {
        controller.printFuncionou();
    }
    
}