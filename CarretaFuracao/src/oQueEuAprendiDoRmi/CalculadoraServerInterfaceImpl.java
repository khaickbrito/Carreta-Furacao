/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oQueEuAprendiDoRmi;

import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculadoraServerInterfaceImpl extends UnicastRemoteObject
    implements CalculadoraServerInterface{

    private Registry r;
    public CalculadoraServerInterfaceImpl(Registry r) throws RemoteException{
        // construtor padrão
        this.r = r;
    }

    // método público que recebe dois valores inteiros e
    // retorna sua soma
    @Override
    public int somar(int a, int b) throws RemoteException{
        return a + b;
    }

    @Override
    public void fecharServidor(String s) {
        try {
            r.unbind(s);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(CalculadoraServerInterfaceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public int pqp() {
//        System.out.println("Vaisifudê");
//        return 2;
//    }

    @Override
    public void imprimirNomeCarro(Carro car) throws RemoteException {
        System.out.println(car.getModelo()); 
    }
    
    
}