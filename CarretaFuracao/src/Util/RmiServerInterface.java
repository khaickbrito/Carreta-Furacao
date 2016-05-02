/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.rmi.*;
import java.rmi.registry.Registry;

public interface RmiServerInterface extends Remote{
    // método público que recebe dois valores inteiros e
    // retorna sua soma
    public int somar(int a, int b) throws RemoteException;
    
    public boolean sendDistance(double dist) throws RemoteException;
    
    public boolean sendSelfPosition(double x, double y) throws RemoteException;
    
    public boolean sendSelfVelocity(double veloc) throws RemoteException;
    
    public boolean changeTrainVelocity(double newVeloc) throws RemoteException;
    
    public boolean sendMaxSpeed(int Maxspeed) throws RemoteException;
    
    public boolean sendToken() throws RemoteException;
    
    public String[] getTrainsIp() throws RemoteException;
}
