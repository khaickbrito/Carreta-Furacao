/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Controller.TrainController;
import Model.RMISSLClientSocketFactory;
import Model.RMISSLServerSocketFactory;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RmiServer extends UnicastRemoteObject implements RmiServerInterface {

    private TrainController controller;
    private int myId;

    public RmiServer(int ID) throws RemoteException, Exception {
        // construtor padrão
//        super(port, new RMISSLClientSocketFactory(),
//              new RMISSLServerSocketFactory());
        myId = ID;
        this.controller = TrainController.getInstance();
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
    public boolean sendNewSpeed(int id, int veloc) throws RemoteException {
        System.out.println("Trem de id " + id + "mudou sua velocidade para" + veloc);
        return controller.changeSpeed(id, veloc);
    }

    /*
        Serve para enviar para o trem portador desse registro a velocidade máxi-
    ma que ele pode trafegar sem invadir a zona compartilhada.
     */
    @Override
    public boolean sendMaxSpeed(int id, int Maxspeed) throws RemoteException {
        return controller.changeMaxSpeed(id, Maxspeed);
    }

    @Override
    public int getId() throws RemoteException {
        return myId;
    }

    /*
    
    addTrem(0, 520, 270, 295, 170, map, 270, 294, 520, 295, 270, 295, 499);
        addTrem(1, 395, 145, 545, 295, map, 145, 545, 270, 295, 395, 545, 375);
        addTrem(2, 645, 395, 545, 295, map, 645, 545, 395, 545, 520, 295, 250);
     */
    @Override
    public void imHere(int id) throws RemoteException {
        if (id == 0) {
            controller.addTrem(0, 520, 270, 295, 170, 270, 294, 520, 295, 270, 295, 499);
        } else if (id == 1) {
            controller.addTrem(1, 395, 145, 545, 295, 145, 545, 270, 295, 395, 545, 375);
        } else if (id == 2) {
            controller.addTrem(2, 645, 395, 545, 295, 645, 545, 395, 545, 520, 295, 250);
        } else {
            System.out.println("Id inválido.");
        }

    }

    @Override
    public void returnOldSpeed() throws RemoteException {
//        controller.returnOldSpeed();
    }

    @Override
    public void sendSelfInfo(int id, int veloc, int x, int y, int dist) throws RemoteException {
        controller.changeTrainInfo(id, veloc, x, y, dist);
    }

}
