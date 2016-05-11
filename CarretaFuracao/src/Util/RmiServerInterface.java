/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.rmi.*;
import java.rmi.registry.Registry;

public interface RmiServerInterface extends Remote{
    
    public boolean sendSelfDistance(double dist) throws RemoteException;
    
    public void sendSelfPosition(int id, int x, int y) throws RemoteException;
    
    public boolean sendNewSpeed(int id, int veloc) throws RemoteException;
    
    public boolean sendMaxSpeed(int id, int Maxspeed) throws RemoteException;
    
    public void imHere(int id) throws RemoteException;
      
    public int getId() throws RemoteException;
    
    public void returnOldSpeed() throws RemoteException;
    
}
